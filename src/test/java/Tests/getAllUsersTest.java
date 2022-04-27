package Tests;

import Requests.getScore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getAllUsersTest {
    @Test
    public void checkScore(){
        String end = "resume/signup";
        Response response = getScore.login(end);
        JsonPath jspath = response.jsonPath();
//        jspath.prettyPrint();
        JSONArray arr = new JSONArray(response.asString());
        JSONObject ele = arr.getJSONObject(1);
        Assert.assertEquals(ele.get("name"),"Parth");
        Assert.assertEquals(ele.get("role"),"Subject Expert");
        Assert.assertEquals(ele.get("email"),"parth@gmail.cpom");
        Assert.assertEquals(ele.get("username"),"parth123");


    }
}
