package Tests;

import Requests.getScore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetAllRecruitmentsTest {

    @Test
    public void getRecruitments(){
        String end = "/resume/getRecruitment";
        Response response = getScore.login(end);
        JsonPath jspath = response.jsonPath();
        jspath.prettyPrint();
    }

}
