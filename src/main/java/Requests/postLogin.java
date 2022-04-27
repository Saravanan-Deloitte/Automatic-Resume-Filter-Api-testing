package Requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

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
                        //.statusCode(HttpStatus.SC_CREATED)

                        .then()
                        .statusCode(202)

                        .extract()
                        .response();
        return response;
    }
}
