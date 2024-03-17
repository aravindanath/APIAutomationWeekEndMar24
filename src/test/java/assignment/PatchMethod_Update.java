package assignment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchMethod_Update {

    String baseUrl = "https://reqres.in/";

    @Test
    public void patchUpdate()
    {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/users/2";

        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("name","morpheus");
        hm.put("job","zion resident");

        Response response = given().log().all().contentType(ContentType.JSON).body(hm).patch();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :"+statusCode);

        String name = response.then().extract().path("name");
        System.out.println("Name field extracted from response :"+name);

        Assert.assertEquals(statusCode, 200, "Status code mismatch");
        Assert.assertEquals(name, "morpheus", "Name incorrect");


    }
}
