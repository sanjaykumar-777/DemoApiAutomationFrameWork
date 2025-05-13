package com.api.tests;



import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApiTest {


    @Test(description = "verify if login is successful without chaining")
    public void loginTestWithoutChaining(){
        baseURI = "http://64.227.160.186:8080";
        RequestSpecification x = given();
        RequestSpecification y = x.header("Content-Type", "application/json");
        RequestSpecification z = y.body("{\"username\": \"sanjaykumar777\", \"password\": \"Sanjay@123\"}");
        Response response = z.post("/api/auth/login");
    System.out.println(response.asPrettyString());
    Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(description = "verify if login is successful with chaining")
    public void loginTestWithChaining(){
        Response response = given()
                .baseUri("http://64.227.160.186:8080")
                .basePath("/api/auth/login")
                .header("Content-Type", "application/json")
                .body("{\"username\": \"sanjaykumar777\", \"password\": \"Sanjay@123\"}")
                .when()
                .post();
    System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }


}
