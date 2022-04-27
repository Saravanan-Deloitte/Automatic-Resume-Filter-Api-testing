package Tests;

import Requests.getScore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompletedRecruitmentsTest {

    @Test
    public void ValidHrID(){
        String end = "resume/completedRecruitments?hr_id=1";
        Response response = getScore.login(end);
        Assert.assertEquals(response.statusCode(),200);
//        JsonPath jspath = response.jsonPath();
//        jspath.prettyPrint();

    }
    @Test (priority = 1)
    public void InvalidHrID(){
        String end = "resume/completedRecruitments?hr_id=@12";
        Response response = getScore.login(end);
        Assert.assertEquals(response.statusCode(),500);
       // JsonPath jspath = response.jsonPath();
        //jspath.prettyPrint();

    }

}
