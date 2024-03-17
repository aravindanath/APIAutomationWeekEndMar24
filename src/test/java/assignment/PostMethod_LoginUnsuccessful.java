package assignment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostMethod_LoginUnsuccessful {

    String baseUrl = "https://reqres.in/";

    @Test
    public void postLoginUnsuccessful() throws FileNotFoundException {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/login";

        String path = System.getProperty("user.dir")+ File.separator+"login_Unsuccessful.json";
        FileInputStream fi = new FileInputStream(path);

        Response response = given().log().all().contentType(ContentType.JSON).body(fi).post();

//        HashMap<String, String> hm = new HashMap<String, String>();
//        hm.put("email","peter@klaven");
//
//        Response response = given().log().all().contentType(ContentType.JSON).body(hm).post();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :"+statusCode);

        Assert.assertEquals(statusCode, 400, "Status code mismatch");

    }
}
