package assignment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PutMethod_Update {

    String baseUrl = "https://reqres.in/";

    @Test
    public void putUpdate()
    {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/users/2";

        JSONObject jo = new JSONObject();
        jo.put("name","morpheus");
        jo.put("job","zion resident");

        Response response = given().log().all().contentType(ContentType.JSON).body(jo).put();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status Code is :"+statusCode);

        String name = response.then().extract().path("name");
        System.out.println("Name field extracted from response :"+name);

        Assert.assertEquals(statusCode, 200, "Status code mismatch");
        Assert.assertEquals(name, "morpheus", "Name incorrect");


    }
}
