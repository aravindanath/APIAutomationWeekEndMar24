package assignment;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetMethod_SingleUser {

    String baseUrl = "https://reqres.in/";

    @Test
    public void getSingleUser()
    {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/users/2";

        Response response = given().log().all().get();

        response.prettyPrint();//Prints the response

        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :"+statusCode);//Prints status code from response

        String text = response.then().extract().path("support.text");//Extracts some response path from response
        System.out.println("Text field extracted from response :"+text);

        Assert.assertEquals(statusCode, 200, "Status code mismatch");
        Assert.assertEquals(text, "To keep ReqRes free, contributions towards server costs are appreciated!", "Message incorrect");


    }
}
