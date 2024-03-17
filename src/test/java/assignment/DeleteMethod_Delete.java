package assignment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DeleteMethod_Delete {

    String baseUrl = "https://reqres.in/";

    @Test
    public void delete()
    {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/users/2";

        Response response = given().log().all().delete();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :"+statusCode);

        Assert.assertEquals(statusCode, 204, "Status code mismatch");

    }
}
