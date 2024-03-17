package assignment;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetMethod_DelayedResponse {

    String baseUrl = "https://reqres.in/";

    @Test
    public void getDelayedResponse() {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/users?delay=3";

        Response response = given().log().all().get();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status code is :" + response.getStatusCode());

        List<String> first_names = response.then().extract().path("data.first_name");
        System.out.println("Count of first_names: "+first_names.size());

        for (String first_name: first_names)
        {
            System.out.println("First Name :"+first_name);
        }

        Assert.assertEquals(statusCode, 200, "Status code mismatch");
    }
}
