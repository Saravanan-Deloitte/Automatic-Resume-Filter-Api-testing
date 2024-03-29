package Tests;

import Requests.getScore;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetUnderProcessRecruitmentsTest {
    Logger logger = Logger.getLogger(GetUnderProcessRecruitmentsTest.class);

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
        logger.info("Checked Status Code and Asserted data also");
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
        logger.info("Checking Null Body");
    }
}
