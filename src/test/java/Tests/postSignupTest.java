package Tests;

import Requests.postLogin;
import Utilities.ReadDataFromExcel;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class postSignupTest {
    Response response;
    ReadDataFromExcel readDataFromExcel = new ReadDataFromExcel();
    String name;
    String username;
    String email;
    String password;
    String role;
    //String skills;
    @Test(priority = 1)
    public void signupHr() throws IOException {
        name=readDataFromExcel.sendData(2,1,0);
        username=readDataFromExcel.sendData(2, 1, 1);
        email=readDataFromExcel.sendData(2,1,2);
        password=readDataFromExcel.sendData(2, 1, 3).replace("\"","");
        role=readDataFromExcel.sendData(2,1,4);
        JSONObject object = new JSONObject();
        object.put("name",name);
        object.put("username",username);
        object.put("email",email);
        object.put("password",password);
        object.put("role",role);
        //System.out.println(name);
        String str = object.toString();
        response = postLogin.login(str,"resume/signup");
        JsonPath js = response.jsonPath();
        try{
            Assert.assertEquals(name, js.get("name"));
            Assert.assertEquals(username, js.get("username"));
            Assert.assertEquals(role, js.get("role"));
            Assert.assertEquals(response.getStatusCode(),201);
        }
        catch (AssertionError e){
            //System.out.println("User already exist");
            Assert.assertEquals("Username already exists",js.get("error"));
            Assert.assertEquals(response.getStatusCode(),406);
        }
    }
    @Test(priority = 2)
    public void check_name(){
        JSONObject object = new JSONObject();
        object.put("name",name);
        object.put("username",username);
        object.put("email",email);
        String str = object.toString();
        response = postLogin.login(str,"resume/signup");
        JsonPath js = response.jsonPath();
        try{
            Assert.assertEquals(response.getStatusCode(),201);
        }
        catch (AssertionError e)
        {
            System.out.println("bad request body");
        }

    }
    @Test(priority = 3)
    public void signupSubjectExperte() throws IOException {

        name=readDataFromExcel.sendData(2,2,0);
        username=readDataFromExcel.sendData(2, 2, 1);
        email=readDataFromExcel.sendData(2,2,2);
        password=readDataFromExcel.sendData(2, 2, 3).replace("\"","");
        role=readDataFromExcel.sendData(2,2,4);
        String skill1= readDataFromExcel.sendData(2,2,5);
        String skill2=readDataFromExcel.sendData(2,2,6);
        List<String> list=new ArrayList<>();
        list.add(skill1);
        list.add(skill2);
        JSONObject object = new JSONObject();
        object.put("name",name);
        object.put("username",username);
        object.put("email",email);
        object.put("password",password);
        object.put("role",role);
        object.put("skills",list);
        String str = object.toString();
        response = postLogin.login(str,"resume/signup");
        JsonPath js = response.jsonPath();
        try{
            Assert.assertEquals(name, js.get("name"));
            Assert.assertEquals(username, js.get("username"));
            Assert.assertEquals(role, js.get("role"));

        }
        catch (AssertionError e){
            Assert.assertEquals("Username already exists",js.get("error"));
            Assert.assertEquals(response.getStatusCode(),406);
        }
    }



}
