package assignment;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetMethod_ListOfResource {

    String baseUrl = "https://reqres.in/";

    @Test
    public void getListOfResources() {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "api/unknown";

        Response response = given().log().all().get();

        response.prettyPrint();

        int statusCode = response.getStatusCode();
        System.out.println("Status code is :" + response.getStatusCode());

        List<Integer> years = response.then().extract().path("data.year");
        System.out.println("Count of year: "+years.size());

        for (int year: years )
        {
            System.out.println("Year :"+year);
        }

        Assert.assertEquals(statusCode, 200, "Status code mismatch");
        //Assert.assertEquals(years, );
    }
}
