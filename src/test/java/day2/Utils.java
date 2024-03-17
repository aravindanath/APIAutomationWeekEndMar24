package day2;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String firstName(){
        Faker faker = new Faker();
       return faker.name().firstName();
    }


    public static String lastName(){
        Faker faker = new Faker();
        return faker.name().lastName();
    }


    public static String email(){
        Faker faker = new Faker();
        return faker.name().fullName().replace(" ","")+"@testmail.com";
    }


    public static String mobileNumber(){
        Faker faker = new Faker();
        return faker.number().digits(10);
    }

    public static String dateofbirth(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Faker faker = new Faker();
        Date dt = faker.date().birthday();
        String strDate= formatter.format(dt);
        return strDate;

    }

    public static String street1(){
        Faker faker = new Faker();
        return faker.address().streetName();
    }
    public static String street2(){
        Faker faker = new Faker();
        return faker.address().streetName();
    }

    public static String city(){
        Faker faker = new Faker();
        return faker.address().city();
    }
    public static String state(){
        Faker faker = new Faker();
        return faker.address().state();
    }
    public static String country(){
        Faker faker = new Faker();
        return faker.address().country();
    }
    public static String pincode(){
        Faker faker = new Faker();
        return faker.address().zipCode();
    }

    public static String password(){
        Faker faker = new Faker();
        return faker.internet().password();
    }
}
