package Tests;

import Requests.getScore;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class getAllUsersTest {
    Logger logger = Logger.getLogger(getAllUsersTest.class);

    Response response;
    JSONArray arr;
    JSONObject ele;
    @Test
    public void AllUsers(){
        String end = "resume/signup";
        Response response = getScore.login(end);
        arr = new JSONArray(response.asString());
        ele = arr.getJSONObject(1);
        logger.info("Checking All Users");
    }
    @Test
    public void checkName()
    {
        Assert.assertEquals(ele.get("name"),"Parth");
        logger.info("Asserted Name");

    }
    @Test
    public void checkRole()
    {
        Assert.assertEquals(ele.get("role"),"Subject Expert");
        logger.info("Asserted role");
    }
    @Test
    public void checkEmail()
    {
        Assert.assertEquals(ele.get("email"),"parth@gmail.cpom");
        logger.info("Asserted Email");
    }
    @Test
    public void checkUsername()
    {
        Assert.assertEquals(ele.get("username"),"parth123");
        logger.info("Asserted Username");
    }
}
