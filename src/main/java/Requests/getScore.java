package Requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;


public class getScore {
    static String url = "https://resume-filter-backend-urtjok3rza-wl.a.run.app/";
    public static Response login(String endpoint){
        Response response =
                given()
                        .baseUri(url)
                        .contentType(ContentType.JSON)
                        .when()
                        .get(endpoint)
                        .then()
                        .extract()
                        .response();

        return response;
    }
}
