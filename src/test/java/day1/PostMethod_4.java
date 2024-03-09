package day1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class PostMethod_4 {
    String baseUrl = "https://reqres.in";

    @Test
    public void getUsers() throws FileNotFoundException {

        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/api/login";
 //Users/aravindanathdm/Documents/Automation_Classes/APIAutomationWeekEndMar24/login.json
        String path = System.getProperty("user.dir")+ File.separator+"login.json";
        FileInputStream fis = new FileInputStream(path);
        Response response = given().log().all().contentType(ContentType.JSON).body(fis).post();

        response.prettyPrint();


       String token  =  response.then().extract().path("token");
       System.out.println("token: " + token);
    }
}
