package assignment;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethod_SingleUserNotFound {

    String baseUrl = "https://reqres.in/";

    @Test
    public void getSingleUserNotFound()
    {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/users/23";

        Response response = given().log().all().get();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status code is :"+response.getStatusCode());

        Assert.assertEquals(statusCode, 404, "Status code not matching");

    }
}
