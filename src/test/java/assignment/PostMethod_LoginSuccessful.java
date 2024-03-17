package assignment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostMethod_LoginSuccessful {

    String baseUrl = "https://reqres.in/";

    @Test
    public void postLoginSuccessful()
    {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/login";

        JSONObject jo = new JSONObject();
        jo.put("email","eve.holt@reqres.in");
        jo.put("password","cityslicka");

        Response response = given().log().all().contentType(ContentType.JSON).body(jo).post();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :"+statusCode);

        String token = response.then().extract().path("token");
        System.out.println("Token field extracted from response :"+token);

        Assert.assertEquals(statusCode, 200, "Status code mismatch");
        Assert.assertEquals(token, "QpwL5tke4Pnpja7X4", "Token incorrect");


    }
}
