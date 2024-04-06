package day2;

import day2.loginPojo.AddContact;
import day2.loginPojo.Login;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AssertionExample {

    String baseUrl = "https://thinking-tester-contact-list.herokuapp.com";
    String token = null;

    @Test(priority = 1)
    public void login() {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/users/login";
        Login lp = new Login();
        lp.setEmail("rr@testmail.com");
        lp.setPassword("Password@123");
        Response response = given().contentType(ContentType.JSON).log().all().body(lp).post();
        response.prettyPrint();
        token = response.then().extract().path("token");
        // System.out.println("Token: " + token);
    }

    @Test(priority = 2)
    public void addContact() {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/contacts";

        AddContact ac = new AddContact();
        ac.setBirthdate(Utils.dateofbirth());
        ac.setCity(Utils.city());
        ac.setFirstName(Utils.firstName());
        ac.setLastName(Utils.lastName());
        ac.setPhone(Utils.mobileNumber());
        ac.setEmail(Utils.email());
        ac.setCountry(Utils.country());
        ac.setPostalCode(Utils.pincode());
        ac.setStreet1(Utils.street1());
        ac.setStreet2(Utils.street2());
        ac.setStateProvince(Utils.state());


        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token).
                log().all()
                .body(ac).post();

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 201,"Response code fail");

        System.out.println("Status code: " + response.getStatusCode());
    }

}