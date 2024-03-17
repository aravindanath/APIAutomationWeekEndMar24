package assignment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostMethod_RegisterSuccessful {

    String baseUrl = "https://reqres.in/";

    @Test
    public void postRegisterSuccessful()
    {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/register";

        Response response = given().log().all().contentType(ContentType.JSON).body("{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}").post();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :"+statusCode);

        int id = response.then().extract().path("id");
        System.out.println("ID field extracted from response :"+id);

        Assert.assertEquals(statusCode, 200, "Status code mismatch");
        Assert.assertEquals(id, 4, "ID incorrect");


    }
}
