package Tests;
import Utilities.ReadDataFromExcel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import Requests.postNewRecruitment;

import java.io.IOException;

public class postCreateRecruitmentTest
{
    Response response;
    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
    @Test
    public void fileUploadTest() throws IOException
    {
        postNewRecruitment Post=new postNewRecruitment();
        response=Post.PostFile("resume/createRecruitment/");
        String Recruitment_name = readDataFromExcel.sendData(3, 0, 0);
        String Category = readDataFromExcel.sendData(3, 1, 0);
        String Start_Date = readDataFromExcel.sendData(3, 3, 0);
        String End_Date = readDataFromExcel.sendData(3, 4, 0);
        JsonPath jspath = response.jsonPath();

        Assert.assertEquals(response.statusCode(),201);
        Assert.assertEquals(Recruitment_name,jspath.getString("name"));
        Assert.assertEquals(Category,jspath.getString("category"));
        Assert.assertEquals(Start_Date,jspath.getString("start_date"));
        Assert.assertEquals(End_Date,jspath.getString("end_date"));
    }

}