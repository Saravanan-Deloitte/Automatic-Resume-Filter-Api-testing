package Tests;

import Requests.getScore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getCheckQuizExists {
    @Test(priority = 1)
    public void checkquizstatus(){
        String end = "resume/checkQuiz?rec_id=20";
        Response response = getScore.login(end);
        // JsonPath jspath = response.jsonPath();
        // jspath.prettyPrint();
       // Assert.assertEquals("Upload result file to update the score",jspath.getString("message"));
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test(priority = 2)
    public void checkstatus(){
        String end = "resume/checkQuiz?rec_id=900";
        Response response = getScore.login(end);
        String str=response.asString();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(str,"[]");


    }
}
