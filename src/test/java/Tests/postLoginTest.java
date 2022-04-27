package Tests;

import Requests.postLogin;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class postLoginTest {
    File json;
    @BeforeClass
    public void getFile()
    {
        json = new File("src/test/java/xyz.json");
    }
    @Test
    public void check_name(){

        Response response = postLogin.login(json,"resume/login");
        JsonPath js = response.jsonPath();
        Assert.assertEquals("Arpit Dadhich", js.get("name"));
        String s = js.get("name");
        System.out.println(s);
//        System.out.println(response.getHeaders().asList());
    }

    @Test
    public void check_username(){
        Response response = postLogin.login(json,"resume/login");
        JsonPath js = response.jsonPath();
        Assert.assertEquals("arp", js.get("username"));
        String s = js.get("username");
        System.out.println(s);
    }

    @Test
    public void check_role(){
        Response response = postLogin.login(json,"resume/login");
        JsonPath js = response.jsonPath();
        Assert.assertEquals("HR", js.get("role"));
        String s = js.get("role");
        System.out.println(s);
    }

}

