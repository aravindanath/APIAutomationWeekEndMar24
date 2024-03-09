package day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetMethod {
    String baseUrl = "https://reqres.in";

    @Test
    public void getUsers() {

        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/api/users?page=2";

        Response response = given().log().all().get();

        int statusCode = response.getStatusCode();

        System.out.println("statusCode = " + statusCode);
        response.prettyPrint();

        String msg = response.then().extract().path("support.text");

        System.out.println("msg = " + msg);

        Assert.assertEquals(statusCode, 200, "Status Code wrong");
        Assert.assertEquals(msg, "To keep ReqRes free, contributions towards server costs are appreciated!", "Msg mismatch");

    }
}
