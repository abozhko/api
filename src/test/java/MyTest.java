import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;


public class MyTest {

    @Test
    public void test() {

        RestAssured.baseURI = "https://api.heroku.com";

        given().
                header("Accept", "application/vnd.heroku+json; version=3").
                header("Authorization", "Bearer daad7464-8052-4059-bc50-6b9b2050b9e8").
                when().
                get("/apps").
        then().
                statusCode(200);
    }

    @Test
    public void createAppWithNonDefaultName() {

        RestAssured.baseURI = "https://api.heroku.com";

        System.out.println(given().
                header("Accept", "application/vnd.heroku+json; version=3").
                header("Content-Type", "application/json").
                header("Authorization", "Bearer 25acaa9d-383d-44ae-b699-27b2b2e04fe3").
                body("{ \"name\" : \"test34343434343333\" }").
                when().
                post("/apps").asString());
    }

}
