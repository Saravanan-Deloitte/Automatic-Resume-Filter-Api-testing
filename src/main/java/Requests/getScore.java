package Requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

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

    public static Response getParam(String endpoint,String id,int param){

        Response response =
                given()
                        .baseUri(url)
                        .contentType(ContentType.JSON)
                        .queryParam(id,param)
                        .when()
                        .get(endpoint)
                        .then().log().body()
                        .extract()
                        .response();
        return response;
    }
}
