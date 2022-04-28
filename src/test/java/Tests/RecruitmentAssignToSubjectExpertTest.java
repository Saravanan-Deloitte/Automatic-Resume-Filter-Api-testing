package Tests;

import Requests.getScore;
import Utilities.ReadDataFromExcel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class RecruitmentAssignToSubjectExpertTest {

    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
    Response response;

    @Test
    public void RecruitmentAssignToSubjectExpert(){
        String end = "resume/addQuiz?exp_id=7";
        response = getScore.login(end);
        Assert.assertEquals(response.statusCode(),200);
    }
    @Test(priority = 1)

    public void ExcelData() throws IOException {
        String name = readDataFromExcel.sendData(5, 2, 1);
        String category = readDataFromExcel.sendData(5, 2, 2);
        String startDate = readDataFromExcel.sendData(5, 2, 3);
        String endDate = readDataFromExcel.sendData(5, 2, 4);

        JSONArray arr = new JSONArray(response.asString());
        JSONObject obj = arr.getJSONObject(0);
        Assert.assertEquals (obj.getInt("id"),17);
        Assert.assertEquals(obj.get("name"), name);
        Assert.assertEquals(obj.get("category"), category);
        Assert.assertEquals(obj.get("start_date"), startDate);
        Assert.assertEquals(obj.get("end_date"), endDate);
    }

    @Test (priority = 1)
    public void InvalidCase(){
        String end = "/resume/addQuiz?exp_id=@21";
        Response response = getScore.login(end);
        Assert.assertEquals(response.statusCode(),500);
    }

}

