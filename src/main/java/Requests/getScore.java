package Requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

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
                .then().log().body()
                    //.statusCode(HttpStatus.SC_OK)
                    .extract()
                    .response();

        return response;
    }
}
