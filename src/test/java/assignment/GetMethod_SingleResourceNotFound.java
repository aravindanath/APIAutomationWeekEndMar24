package assignment;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethod_SingleResourceNotFound {

    String baseUrl = "https://reqres.in/";

    @Test
    public void getSingleResourceNotFound()
    {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/unknown/23";

        Response response = given().log().all().get();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status code is :"+response.getStatusCode());

        Assert.assertEquals(statusCode, 404, "Status code not matching");

    }
}
