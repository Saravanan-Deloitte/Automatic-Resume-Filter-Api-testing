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
public class getCheckQuizExists {
    Logger logger = Logger.getLogger(getCheckQuizExists.class);

    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
    Response response;
    @Test(priority = 1)
    public void checkquizstatus() throws IOException {
        String endpoint = "resume/checkQuiz";
        String id="rec_id";
        int param=20;
        String quizLink = readDataFromExcel.sendData(2, 3, 0);
        String endDate = readDataFromExcel.sendData(2, 3, 1);
        String questions = readDataFromExcel.sendData(2, 3, 2);
        response = getScore.getParam(endpoint,id,param);
        JSONArray array = new JSONArray(response.asString());
        JSONObject element = array.getJSONObject(0);
        Assert.assertEquals(element.get("id"),32);
        Assert.assertEquals(element.get("quiz_link"),quizLink);
        Assert.assertEquals(element.get("end_date"),endDate);
        Assert.assertEquals(element.get("questions"),questions);
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("Check Details of Quiz and Assert them");

    }

    @Test(priority = 2)
    public void checkstatus(){
        String endpoint = "resume/checkQuiz";
        String id="rec_id";
        int param=500;
        response = getScore.getParam(endpoint,id,param);
        String str=response.asString();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(str,"[]");
        logger.info("Check Status Code");
    }
}