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

public class GetAllRecruitmentsTest {
    Logger logger = Logger.getLogger(GetAllRecruitmentsTest.class);

    Response response;
    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();

    @Test(priority = 1)
    public void getRecruitments(){
        String end = "/resume/getRecruitment";
        response = getScore.login(end);
        Assert.assertEquals(response.statusCode(),200);
        logger.info("Get All Lists of Recruitment by HR.");
    }

    @Test(priority = 2)
    public void assertStatusCode(){
        Assert.assertEquals(response.statusCode(),200);
        logger.info("Status Code Verified.");
    }

    @Test(priority = 3)
    public void assertResponse(){
        String res = String.valueOf(response.body());
        Assert.assertEquals(true,!(res.isEmpty()));
    }

    @Test(priority = 4)
    public void assertResponseData() throws IOException {
        String name = readDataFromExcel.sendData(1, 2, 0);
        String category = readDataFromExcel.sendData(1, 2, 1);
        String startDate = readDataFromExcel.sendData(1, 2, 2).replace("\"","");
        String endDate = readDataFromExcel.sendData(1, 2, 3).replace("\"","");

        JSONArray arr = new JSONArray(response.asString());
        JSONObject obj = arr.getJSONObject(0);
        Assert.assertEquals (obj.getInt("id"),1);
        Assert.assertEquals(obj.get("name"), name);
        Assert.assertEquals(obj.get("category"), category);
        Assert.assertEquals(obj.get("start_date"), startDate);
        Assert.assertEquals(obj.get("start_date"), endDate);

        logger.info("Did Assertions for Get all Recruitments.");
    }

}
