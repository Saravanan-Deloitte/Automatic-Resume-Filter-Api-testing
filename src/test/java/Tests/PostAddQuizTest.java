package Tests;

import Requests.postLogin;
import Utilities.ReadDataFromExcel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class PostAddQuizTest {
    ReadDataFromExcel readDataFromExcel=new ReadDataFromExcel();
    Response response;
    String str;
    String quizLink = readDataFromExcel.sendData(1, 1, 0);
    String endDate = readDataFromExcel.sendData(1, 1, 1).replace("\"","");
    String dueTime = readDataFromExcel.sendData(1, 1, 2).replace("\"","");
    String questions = readDataFromExcel.sendData(1, 1, 3).replace("\"","");

    public PostAddQuizTest() throws IOException {
    }

    @Test(priority = 1)
    public void addQuizData() throws IOException {
        JSONObject object = new JSONObject();
        object.put("recruitment",239);
        object.put("quiz_link",quizLink);
        object.put("end_date",endDate);
        object.put("due_time",dueTime);
        object.put("questions",questions);
        str = object.toString();
        response = postLogin.postParam(str,"resume/addQuiz","exp_id",294);
    }

    @Test(priority = 2)
    public void assertStatusCode(){
        Assert.assertEquals(response.statusCode(),201);
    }

    @Test(priority = 3)
    public void assertResponse(){
        String res = String.valueOf(response.body());
        Assert.assertEquals(!(res.isEmpty()),true);
    }

    @Test(priority = 4)
    public void assertResponseData(){
        JsonPath path=response.jsonPath();
        Assert.assertEquals(path.get("quiz_link"), quizLink);
        Assert.assertEquals(path.get("end_date"), endDate);
        Assert.assertEquals(path.get("due_time"), dueTime);
        Assert.assertEquals(path.get("questions"), questions);
        Assert.assertEquals(path.getInt("recruitment"), 239);
        Assert.assertEquals(path.getInt("expert_id"),294);
    }

    @Test(priority = 5)
    public void addQuizDataNegativeCase1() throws IOException {
        response = postLogin.postParam(str,"resume/addQuiz","exp_id",0);
        Assert.assertEquals(response.statusCode(),400);
        JSONObject ele = new JSONObject(response.asString());
        Assert.assertEquals(ele.getJSONArray("expert_id").toString(), "[\"Invalid pk \\\"0\\\" - object does not exist.\"]");
    }

    @Test(priority = 6)
    public void addQuizDataNegativeCase2() throws IOException {
        response = postLogin.postParam(str,"resume/addQuiz","exp_id",-1);
        Assert.assertEquals(response.statusCode(),400);
        JSONObject ele = new JSONObject(response.asString());
        Assert.assertEquals(ele.getJSONArray("expert_id").toString(), "[\"Invalid pk \\\"-1\\\" - object does not exist.\"]");
    }
}
