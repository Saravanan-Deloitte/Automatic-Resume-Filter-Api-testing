package Tests;
import Requests.getScore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
public class getAllSubjectExpertTest
{
    Response response;
    JSONArray arr;

    @Test(priority = 1)
    public void getAllExpert(){
        String end = "resume/getSubExperts";
        response = getScore.login(end);
        arr = new JSONArray(response.asString());
    }

    @Test(priority = 2)
    public void assertUser() {
        JSONObject data1 = arr.getJSONObject(0);
        Assert.assertEquals(data1.get("name"),"Parth");
        JSONObject data2 = arr.getJSONObject(1);
        Assert.assertEquals(data2.get("name"),"Vidushi Singh");
    }
}