package day2;

import day2.loginPojo.AddContact;
import day2.loginPojo.Login;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AssertionExample_HamcrustLib {

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
        String country =Utils.country();
        AddContact ac = new AddContact();
        ac.setBirthdate(Utils.dateofbirth());
        ac.setCity(Utils.city());
        ac.setFirstName(Utils.firstName());
        ac.setLastName(Utils.lastName());
        ac.setPhone(Utils.mobileNumber());
        ac.setEmail(Utils.email());
        ac.setCountry(country);
        ac.setPostalCode(Utils.pincode());
        ac.setStreet1(Utils.street1());
        ac.setStreet2(Utils.street2());
        ac.setStateProvince(Utils.state());


       RequestSpecification req = Utils.specBuilder(token);
       Response  response =   req.body(ac).post();

        response.prettyPrint();

         response.then().assertThat().statusCode(201).body("country",equalTo(country));

        System.out.println("Status code: " + response.getStatusCode());
    }

}