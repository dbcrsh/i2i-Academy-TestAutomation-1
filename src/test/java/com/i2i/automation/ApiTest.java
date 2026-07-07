package com.i2i.automation;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @Test
    public void getKullaniciBilgisiTesti() {
        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .time(lessThan(5000L))
                .body("name", equalTo("Leanne Graham"));
    }

    @Test
    public void postYeniKullaniciTesti() {
        String jsonGövdesi = "{\"title\": \"testAutomation\", \"body\": \"apiTest\", \"userId\": 1}";

        given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .header("Content-Type", "application/json")
                .body(jsonGövdesi)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("title", equalTo("testAutomation"))
                .body("userId", equalTo(1));
    }
}