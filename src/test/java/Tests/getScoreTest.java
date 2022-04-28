package Tests;
import Requests.getScore;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getScoreTest {
    @Test
    public void checkScore(){
        String end = "resume/checkScore?rec_id=16";
        Response response = getScore.login(end);
        JsonPath jspath = response.jsonPath();
        jspath.prettyPrint();
        Assert.assertEquals("Upload result file to update the score",jspath.getString("message"));
        Assert.assertEquals(response.statusCode(),200);
    }
}
