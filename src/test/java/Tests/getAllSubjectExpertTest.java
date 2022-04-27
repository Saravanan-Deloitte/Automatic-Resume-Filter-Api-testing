package Tests;

import Requests.getScore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class getAllSubjectExpertTest
{
    @Test
    public void getAllExpert(){
        String end = "resume/getSubExperts";
        Response response = getScore.login(end);
        JsonPath jspath = response.jsonPath();
        jspath.prettyPrint();
    }
    //
}
