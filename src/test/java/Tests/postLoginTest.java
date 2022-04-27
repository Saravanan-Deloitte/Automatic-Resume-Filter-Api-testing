package Tests;

import Requests.postLogin;
import Utilities.ReadDataFromExcel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class postLoginTest {
    Response response;
    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();

    @Test(priority = 1)
    public void login() throws IOException {
        String username=readDataFromExcel.sendData(0, 1, 0);
        String password=readDataFromExcel.sendData(0, 1, 1).replace("\"","");
        System.out.println(username);
        System.out.println(password);
        JSONObject object = new JSONObject();
        object.put("username",username);
        object.put("password",password);
        String str = object.toString();
        response = postLogin.login(str,"resume/login");
    }
    @Test(priority = 2)
    public void check_name(){
        JsonPath js = response.jsonPath();
        Assert.assertEquals("Arpit Dadhich", js.get("name"));
        String s = js.get("name");
        System.out.println(s);
//        System.out.println(response.getHeaders().asList());
    }

    @Test(priority = 3)
    public void check_username(){
        JsonPath js = response.jsonPath();
        Assert.assertEquals("arp", js.get("username"));
        String s = js.get("username");
        System.out.println(s);
    }

    @Test(priority = 4)
    public void check_role(){
        JsonPath js = response.jsonPath();
        Assert.assertEquals("HR", js.get("role"));
        String s = js.get("role");
        System.out.println(s);
    }

}

