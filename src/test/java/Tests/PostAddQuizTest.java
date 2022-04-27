package Tests;

import Requests.postLogin;
import Utilities.ReadDataFromExcel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class PostAddQuizTest {
    ReadDataFromExcel readDataFromExcel=new ReadDataFromExcel();
    Response response;
    String quizLink = readDataFromExcel.sendData(1, 1, 0);
    String endDate = readDataFromExcel.sendData(1, 1, 1).replace("\"","");
    String dueTime = readDataFromExcel.sendData(1, 1, 2).replace("\"","");
    String questions = readDataFromExcel.sendData(1, 1, 3).replace("\"","");

    public PostAddQuizTest() throws IOException {
    }

    @Test(priority = 1)
    public void addQuizData() throws IOException {
        System.out.println(quizLink+" "+endDate+" "+dueTime+" "+questions);
        JSONObject object = new JSONObject();
        object.put("recruitment",239);
        object.put("quiz_link",quizLink);
        object.put("end_date",endDate);
        object.put("due_time",dueTime);
        object.put("questions",questions);
        String str = object.toString();
        response = postLogin.postParam(str,"resume/addQuiz","exp_id",294);
    }

    @Test(priority = 2)
    public void assertStatusCode(){
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test(priority = 3)
    public void assertResponse(){
        String res = String.valueOf(response.body());
        Assert.assertEquals(true,!(res.isEmpty()));
    }

    @Test(priority = 4)
    public void assertResponseData(){
        JsonPath path=response.jsonPath();
        path.prettyPrint();
    }
}
