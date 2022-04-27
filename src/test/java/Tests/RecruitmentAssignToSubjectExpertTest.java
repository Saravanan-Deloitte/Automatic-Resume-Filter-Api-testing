package Tests;

import Requests.getScore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class RecruitmentAssignToSubjectExpertTest {

    @Test
    public void RecruitmentAssignToSubjectExpert(){
        String end = "/resume/addQuiz?exp_id=7";
        Response response = getScore.login(end);
        JsonPath jspath = response.jsonPath();
        //jspath.prettyPrint();
    }

}

