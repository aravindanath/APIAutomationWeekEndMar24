package day1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostMethod {
    String baseUrl = "https://reqres.in";

    @Test
    public void getUsers() {

        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/api/users";

        Response response = given().log().all().contentType(ContentType.JSON).body("{\n" +
                "    \"name\": \"Deepika\",\n" +
                "    \"job\": \"Automation leader\"\n" +
                "}").post();

       System.out.println("Status Code: "+ response.getStatusCode());
       response.prettyPrint();
       String id = response.then().extract().path("id");
       System.out.println("Id: "+ id);
    }
}
