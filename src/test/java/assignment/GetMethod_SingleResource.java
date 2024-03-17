package assignment;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethod_SingleResource {

    String baseUrl = "https://reqres.in/";

    @Test
    public void getSingleResource()
    {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/unknown/2";

        Response response = given().log().all().get();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status code is :"+response.getStatusCode());

        String name = response.then().extract().path("data.name");
        System.out.println("Name field extracted from response :"+name);

        Assert.assertEquals(statusCode, 200, "Status code mismatch");
        Assert.assertEquals(name, "fuchsia rose", "Name incorrect");
    }
}
