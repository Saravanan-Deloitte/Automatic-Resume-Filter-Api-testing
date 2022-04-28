package Tests;

import Requests.postLogin;
import Utilities.ReadDataFromExcel;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SendQuizToCandidatesTest {
    Response response;
    ReadDataFromExcel excel =new ReadDataFromExcel();
    @Test(priority = 1)
    public void sendQuiz() throws IOException {
        RestAssured.useRelaxedHTTPSValidation();
        String quizLink=excel.sendData(4, 1, 0);
        System.out.println(quizLink);
        JSONObject object = new JSONObject();
        object.put("quizLink",quizLink);
        String str = object.toString();
        response = postLogin.login(str,"resume/sendQuiz?rec_id=255");
        JsonPath js = response.jsonPath();
        Assert.assertEquals("Quiz link Sent", js.get("message"));
        Assert.assertEquals(response.statusCode(),200);
    }
}
