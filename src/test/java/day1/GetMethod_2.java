package day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetMethod_2 {
    String baseUrl = "https://reqres.in";

    @Test
    public void getUsers() {

        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/api/users?page=2";

        Response response = given().log().all().get();

        int statusCode = response.getStatusCode();

        System.out.println("statusCode = " + statusCode);
        response.prettyPrint();

         List<String> emails =  response.then().extract().path("data.email");

         System.out.println("Email Count: "+emails.size());
         for(String email : emails){
             System.out.println("Email: "+email);
         }

    }
}
