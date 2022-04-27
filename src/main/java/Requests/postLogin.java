package Requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class postLogin {
    static String url = "https://resume-filter-backend-urtjok3rza-wl.a.run.app/";
    public static Response login(String login, String endpoint){
        Response response =
                given()
                        .baseUri(url)
                        .contentType(ContentType.JSON)
                        .when()
                        .body(login)
                        .post(endpoint)
                        .then().log().body()
                        .extract()
                        .response();
        return response;
    }

    public static Response postParam(String login, String endpoint,String id,int param){

        Response response =
                given()
                        .baseUri(url)
                        .contentType(ContentType.JSON)
                        .queryParam(id,param)
                        .when()
                        .body(login)
                        .post(endpoint)
                        .then().log().body()
                        .extract()
                        .response();
        return response;
    }
}
