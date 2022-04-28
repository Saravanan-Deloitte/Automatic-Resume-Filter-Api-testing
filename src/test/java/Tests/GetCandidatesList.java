package Tests;

import Requests.getScore;
import Utilities.ReadDataFromExcel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetCandidatesList {
    Logger logger = Logger.getLogger(GetCandidatesList.class);
    Response response;
    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();

    @Test(priority = 1)
    public void candidatesList(){
        String end = "/resume/candidates?rec_id=18";
        response = getScore.login(end);
        Assert.assertEquals(response.statusCode(),200);
        logger.info("Get all candidates list");
    }

    @Test(priority = 2)
    public void assertStatusCode(){
        Assert.assertEquals(response.statusCode(),200);
        logger.info("Asserted Status Code");
    }

    @Test(priority = 3)
    public void assertResponse(){
        String res = String.valueOf(response.body());
        Assert.assertEquals(true,!(res.isEmpty()));
    }

    @Test(priority = 4)
    public void assertResponseData() throws IOException {
        String name = readDataFromExcel.sendData(1, 3, 0);
        String email = readDataFromExcel.sendData(1, 3, 1);
        String phone = readDataFromExcel.sendData(1, 3, 2).replace("\"", "");
        String eligibility = readDataFromExcel.sendData(1, 3, 3);
        String status = readDataFromExcel.sendData(1, 3, 4);
        String quizSent = readDataFromExcel.sendData(1, 3, 5);

        JSONArray arr = new JSONArray(response.asString());
        JSONObject obj = arr.getJSONObject(0);
        Assert.assertEquals(obj.getInt("id"), 41);
        Assert.assertEquals(obj.get("candidate_name"), name);
        Assert.assertEquals(obj.get("candidate_email"), email);
        Assert.assertEquals(obj.get("candidate_phone"), phone);
        Assert.assertEquals(obj.get("quizEligibility"), eligibility);
        Assert.assertEquals(obj.get("status"), status);
        Assert.assertEquals(obj.get("quizSent"), quizSent);
        Assert.assertEquals(obj.get("recruitment"), 18);

        logger.info("Asserted Data of Candidates");
    }
}
