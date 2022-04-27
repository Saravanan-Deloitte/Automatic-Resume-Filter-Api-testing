package Requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;


public class postLogin {
    static String url = "https://resume-filter-backend-urtjok3rza-wl.a.run.app/";
    public static Response login(File login, String endpoint){
        Response response =
                given()
                        .baseUri(url)
                        .contentType(ContentType.JSON)
                        .when()
                        .body(login)
                        .post(endpoint)
                        .then()
                        .extract()
                        .response();

        return response;
    }
}
