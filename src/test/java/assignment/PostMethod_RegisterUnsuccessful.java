package assignment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PostMethod_RegisterUnsuccessful {

    String baseUrl = "https://reqres.in/";

    @Test
    public void postRegisterUnsuccessful()
    {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/register";

        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("email","sydney@fife");
        
        Response response = given().log().all().contentType(ContentType.JSON).body(hm).post();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :"+statusCode);

        Assert.assertEquals(statusCode, 400, "Status code mismatch");

    }
}
