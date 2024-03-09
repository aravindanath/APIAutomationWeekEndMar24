package day1;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostMethod_3 {
    String baseUrl = "https://reqres.in";

    @Test
    public void getUsers() {

        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/api/login";

        JSONObject loginData =  new JSONObject();
        loginData.put("email", "eve.holt@reqres.in");
        loginData.put("password","cityslicka");



        Response response = given().log().all().contentType(ContentType.JSON).body(loginData).post();

        response.prettyPrint();

       String token  =  response.then().extract().path("token");
       System.out.println("token: " + token);
    }
}
