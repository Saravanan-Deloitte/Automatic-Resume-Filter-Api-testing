package Tests;

import Requests.getScore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetAllRecruitmentsTest {

    @Test
    public void getRecruitments(){
        String end = "/resume/getRecruitment";
        Response response = getScore.login(end);
        Assert.assertEquals(response.statusCode(),200);
        JsonPath jspath = response.jsonPath();
        //jspath.prettyPrint();
    }

}
