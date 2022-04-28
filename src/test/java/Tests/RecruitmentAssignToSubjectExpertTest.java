package Tests;

import Requests.getScore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RecruitmentAssignToSubjectExpertTest {

    @Test
    public void RecruitmentAssignToSubjectExpert(){
        String end = "resume/addQuiz?exp_id=7";
        Response response = getScore.login(end);
        Assert.assertEquals(response.statusCode(),200);
    }

    @Test (priority = 1)
    public void InvalidCase(){
        String end = "/resume/addQuiz?exp_id=@21";
        Response response = getScore.login(end);
        Assert.assertEquals(response.statusCode(),500);
    }

}

