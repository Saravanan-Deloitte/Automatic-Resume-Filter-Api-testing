package Requests;

import Utilities.ReadDataFromExcel;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class postNewRecruitment
{
    Response response;
    File file;

    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
    public Response PostFile(String Endpoint) throws IOException
    {
        String Recruitment_name = readDataFromExcel.sendData(3, 0, 0);
        String Category = readDataFromExcel.sendData(3, 1, 0);
        String Skills = readDataFromExcel.sendData(3, 2, 0);
        String Start_Date = readDataFromExcel.sendData(3, 3, 0);
        String End_Date = readDataFromExcel.sendData(3, 4, 0);
        String Expert = readDataFromExcel.sendData(3, 5, 0).replace("\"","");
        String Created_By = readDataFromExcel.sendData(3, 6, 0).replace("\"","");
        file = new File("C:\\Users\\ksaravanakumar\\Documents\\Automatic-Resume-Filter-Api-testing\\src\\main\\java\\Utilities\\Resumes.zip");
        response=given()
                .baseUri("https://resume-filter-backend-urtjok3rza-wl.a.run.app/")
                .formParam("name", Recruitment_name).formParam("category", Category)
                .formParam("skills",Skills ).formParam("start_date", Start_Date)
                .formParam("end_date",End_Date)
                .multiPart("resume",file)
                .formParam("expert",Expert)
                .formParam("created_by", Created_By)
                .when()
                .post(Endpoint)
                .then()
                .extract()
                .response();
        return response;
    }
}
