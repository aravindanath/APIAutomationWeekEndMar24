package day2;

import day2.loginPojo.AddContact;
import day2.loginPojo.AddUser;
import day2.loginPojo.Login;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC_002 {

    String baseUrl = "https://thinking-tester-contact-list.herokuapp.com";
    String token = null;

    @Test(priority = 1)
    public void login() {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/users/login";
        Login lp = new Login();
        lp.setEmail("noreply@test.com");
        lp.setPassword("Heroukapp123*");
        Response response = given().contentType(ContentType.JSON).log().all().body(lp).post();
        response.prettyPrint();
        token = response.then().extract().path("token");
        // System.out.println("Token: " + token);
    }

    @Test(priority = 2)
    public void addUser()
    {

        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/users";

        AddUser au = new AddUser();
        au.setFirstName(Utils.firstName());
        au.setLastName(Utils.lastName());
        au.setEmail(Utils.email());
        au.setPassword(Utils.password());

        Response response = given().log().all().
                contentType(ContentType.JSON).
                header("Authorization","Bearer "+token).
                body(au).
                post();

        response.prettyPrint();

        System.out.println("Status code: "+response.getStatusCode());

    }

    @Test(priority = 3)
    public void updateUser()
    {

        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/users/me";

        AddUser au = new AddUser();
        au.setFirstName(Utils.firstName());
        au.setLastName(Utils.lastName());
        au.setEmail(Utils.email());
        au.setPassword(Utils.password());

        Response response = given().log().all().
                contentType(ContentType.JSON).
                header("Authorization","Bearer "+token).
                body(au).
                patch();

        response.prettyPrint();

        System.out.println("Status code: "+response.getStatusCode());

    }

    @Test(priority = 4)
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

        System.out.println("Status code: " + response.getStatusCode());
    }

    @Test(priority = 5)
    public void updateContact() {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/contacts/";

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
                .body(ac).put();

        response.prettyPrint();

        System.out.println("Status code: " + response.getStatusCode());
    }

    @Test(priority = 6)
    public void updateContact2() {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = "/contacts/";

        AddContact ac = new AddContact();
        ac.setFirstName(Utils.firstName());

        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token).
                 log().all()
                .body(ac).patch();

        response.prettyPrint();

        System.out.println("Status code: " + response.getStatusCode());
    }



}
