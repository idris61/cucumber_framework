package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Registrant;
import pojos.TestItem1;

import static io.restassured.RestAssured.given;

public class ApiUtils {


    public static Response getRequest(String token, String endpoint) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().get(endpoint);


        return response;

    }

    public static Response putRequest(String token, String endpoint, Registrant registrant) {

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).contentType(ContentType.JSON).body(registrant).when().put(endpoint);


        return response;

    }
    public static Response postRequestTestItems(String endpoint, TestItem1 data) {
        Response response = given().headers(
                        "Authorization",
 //                       "Bearer " + generateToken(ConfigReader.getProperty("adminUN"), ConfigReader.getProperty("adminPW")),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                body(data).contentType(ContentType.JSON).
                when().
                post(endpoint);
        return response;
    }




    public static Response deleteRequest (String token, String endpoint){

        Response response = given().headers(
                "Authorization",
                "Bearer " + token,
                "Content-Type",
                ContentType.JSON,
                "Accept",
                ContentType.JSON).when().delete(endpoint);

        return response;

    }
}