package Tests;

import Requests.postLogin;
import Utilities.ReadDataFromExcel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class postLoginTest {


    Logger logger = Logger.getLogger(postLoginTest.class);
    Response response;
    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
    JSONObject object;
    String username=readDataFromExcel.sendData(0, 1, 0);
    String password=readDataFromExcel.sendData(0, 1, 1).replace("\"","");


    public postLoginTest() throws IOException {
        logger.info("Doing Login Process");


        object = new JSONObject();
        String str = object.toString();
        response = postLogin.login(str,"resume/login");
    }

    @Test(priority = 1)
    public void loginOnlyUsername() throws IOException {
        object.put("username",username);
        String str = object.toString();
        response = postLogin.login(str,"resume/login");
        Assert.assertEquals(response.statusCode(),500);
        logger.info("************ Negative Test Cases ************");
    }

    @Test(priority = 2)
    public void login()
    {
        object.put("username",username);
        object.put("password",password);
        String str = object.toString();
        response = postLogin.login(str,"resume/login");
        Assert.assertEquals(response.statusCode(),202);
        logger.info("Actual Login Done");
    }
    @Test(priority = 3)
    public void check_name(){
        JsonPath js = response.jsonPath();
        Assert.assertEquals("Arpit Dadhich", js.get("name"));
        Assert.assertEquals(response.statusCode(),202);
        logger.info("Asserted Name");
    }


    @Test(priority = 4)
    public void check_username(){
        JsonPath js = response.jsonPath();
        Assert.assertEquals("arp", js.get("username"));
        Assert.assertEquals(response.statusCode(),202);
        logger.info("Asserted username");
    }

    @Test(priority = 5)
    public void check_role(){
        JsonPath js = response.jsonPath();
        Assert.assertEquals("HR", js.get("role"));
        Assert.assertEquals(response.statusCode(),202);
        logger.info("Asserted Role");
    }

}

