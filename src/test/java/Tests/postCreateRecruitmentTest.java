package Tests;

import Requests.postLogin;
import Utilities.ReadDataFromExcel;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class postCreateRecruitmentTest
{
    Response response;
    File file;
    String str,str1;

    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
    /*@BeforeClass
    public void initializeProperties() throws IOException
    {
        properties = new Properties();
        properties.load(new FileInputStream("src/main/resources/data.properties"));
    }*/
    @Test
    public void fileUploadTest() throws IOException
    {
        String Recruitment_name = readDataFromExcel.sendData(3, 1, 0);
        String Category = readDataFromExcel.sendData(3, 2, 0);
        String Skills = readDataFromExcel.sendData(3, 3, 0);
        String Start_Date = readDataFromExcel.sendData(3, 4, 0);
        String End_Date = readDataFromExcel.sendData(3, 5, 0);
        String Expert = readDataFromExcel.sendData(3, 6, 0);
        String Created_By = readDataFromExcel.sendData(3, 6, 0);
        JSONObject object = new JSONObject();
        object.put("name", Recruitment_name);
        object.put("category", Category);
        object.put("skills", Skills);
        object.put("start_date", Start_Date);
        object.put("end_date", End_Date);
        JSONObject object1 = new JSONObject();
        object1.put("expert", Expert);
        object1.put("created_by", Created_By);
        str1=object1.toString();
        str = object.toString();
        response=demo("resume/createRecruitment/");
        JsonPath jspath = response.jsonPath();
        jspath.prettyPrint();

    }
    public Response demo(String Endpoint)
    {
        file = new File("C:\\Users\\ksaravanakumar\\Documents\\Automatic-Resume-Filter-Api-testing\\src\\main\\java\\Utilities\\Resumes.zip");
        response=given()
                .baseUri("https://resume-filter-backend-urtjok3rza-wl.a.run.app/")
                .formParam("name", "Intergartion Master13").formParam("category", "ITM")
                .formParam("skills", "s,k").formParam("start_date", "2022-04-28")
                .formParam("end_date", "2022-04-30")
                .multiPart("resume",file)
                .formParam("expert","3")
                .formParam("created_by", "78")
                .when()
                .post(Endpoint)
                .then()
                .statusCode(201)
                .extract()
                .response();
        return response;
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
