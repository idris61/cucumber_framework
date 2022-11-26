package stepDefinitions.APISteps;

import baseURL.MedunnaBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetRequest01 extends MedunnaBaseUrl {




    @Test
    public void test1(){

       spec.pathParams("first","physicians","second","147333");

       Response response = given()
               .spec(spec)
               .header("Authorization", "Bearer " + generateToken())
               .when()
               .get("/{first}/{second}");

       response.prettyPrint();

       // MATHCHERS CLASS İLE
       response.then().assertThat()
               .body("id", equalTo(147333)
                       ,"firstName", equalTo("Doktor")
                       ,"lastName", equalTo("Yusuf")
                       ,"phone", equalTo("555-555-5555")
                       ,"gender", equalTo("MALE")
                       ,"user.login", equalTo("doktoryusuf")
                       ,"user.email", equalTo("doktoryusuf@gmail.com")
                       ,"user.ssn", equalTo("751-01-0103")
                       ,"speciality", equalTo("NUCLEAR_MEDICINE"));

       // JSON PATH İLE
       JsonPath json = response.jsonPath();
       Assert.assertEquals(147333, json.getInt("id"));
       Assert.assertEquals("Yusuf", json.getString("lastName"));
       Assert.assertEquals("Doktor", json.getString("firstName"));
       Assert.assertEquals("555-555-5555", json.getString("phone"));
       Assert.assertEquals("MALE", json.getString("gender"));
       Assert.assertEquals("doktoryusuf", json.getString("user.login"));
       Assert.assertEquals("doktoryusuf@gmail.com", json.getString("user.email"));
       Assert.assertEquals("751-01-0103", json.getString("user.ssn"));
       Assert.assertEquals("NUCLEAR_MEDICINE", json.getString("speciality"));

    }
}
