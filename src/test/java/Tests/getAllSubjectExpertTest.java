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
    /*public Response demo(String Endpoint)
    {
        file = new File("C:\\Users\\ksaravanakumar\\Documents\\Automatic-Resume-Filter-Api-testing\\src\\main\\java\\Utilities\\Resumes.zip");
        response=given()
                .baseUri("https://resume-filter-backend-urtjok3rza-wl.a.run.app/")
                .formParam("name",properties.getProperty("Recruitment_Name")).formParam("category", properties.getProperty("Recruitment_Category"))
                .formParam("skills", properties.getProperty("Recruitment_Skills")).formParam("start_date", properties.getProperty("Start_Date"))
                .formParam("end_date", properties.getProperty("End_Date"))
                .multiPart("resume",file)
                .formParam("expert",properties.getProperty("Field_Expert_id"))
                .formParam("created_by", properties.getProperty("Recruitment_Created_By"))
                .when()
                .post(Endpoint)
                .then()
                .statusCode(201)
                .extract()
                .response();
        return response;
    }*/
}
