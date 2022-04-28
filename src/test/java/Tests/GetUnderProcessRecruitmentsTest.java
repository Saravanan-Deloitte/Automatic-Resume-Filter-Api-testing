package Tests;

import Requests.getScore;
import io.restassured.RestAssured;
<<<<<<< HEAD
import io.restassured.path.json.JsonPath;
=======
>>>>>>> origin/main
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
<<<<<<< HEAD
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
=======
>>>>>>> origin/main

public class GetUnderProcessRecruitmentsTest {
    @Test(priority = 1)
    public void checkStatus(){
        RestAssured.useRelaxedHTTPSValidation();
        String endpoint = "resume/getUnderProcessRecruitments";
        String id="hr_id";
        int param=1;
        Response response = getScore.getParam(endpoint,id,param);
        Assert.assertEquals(response.getStatusCode(),200);
        JSONArray arr = new JSONArray(response.asString());
        JSONObject ele = arr.getJSONObject(1).getJSONObject("expert");
        Assert.assertEquals(ele.get("id"),5);
        Assert.assertEquals(ele.get("name"),"Vidushi Singh");
        Assert.assertEquals(ele.get("username"),"vidushi");
        Assert.assertEquals(ele.get("email"),"vidu.s1999@gmail.com");
        Assert.assertEquals(ele.get("role"),"Subject Expert");
    }
    @Test(priority = 2)
    public void checkNull(){
        String endpoint = "resume/getUnderProcessRecruitments";
        String id="hr_id";
        int param=500;
        Response response = getScore.getParam(endpoint,id,param);
        String str=response.asString();
        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(str,"[]");
    }
}
