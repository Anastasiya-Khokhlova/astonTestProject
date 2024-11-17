package org.example;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class EchoTest {


    @Test
    public void getTest() {

        given()
                .baseUri("https://postman-echo.com/get")
                .contentType(ContentType.JSON)
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/get"));

    }

    @Test
    public void firstPostTest() {
        given()
                .baseUri("https://postman-echo.com/post")
                .contentType(ContentType.TEXT)
                .body("{\n" +
                        "    \"test\": \"value\"\n" +
                        "}")
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data",equalTo("{\n    \"test\": \"value\"\n}"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void secondPostTest() {
        HashMap<String,String> params = new HashMap<>();
        params.put("foo1","bar1");
        params.put("foo2","bar2");
        given()
                .baseUri("https://postman-echo.com/post")
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParams(params)
                .when()
                .post()
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body("form.foo1", equalTo("bar1"),"form.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));

    }

    @Test
    public void putTest() {
        given()
                .baseUri("https://postman-echo.com/put")
                .contentType(ContentType.TEXT)
                .body("{\n" +
                        "    \"test\": \"value\"\n" +
                        "}")
                .when()
                .put()
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data",equalTo("{\n    \"test\": \"value\"\n}"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void patchTest() {
        given()
                .baseUri("https://postman-echo.com/patch")
                .contentType(ContentType.TEXT)
                .body("{\n" +
                        "    \"test\": \"value\"\n" +
                        "}")
                .when()
                .patch()
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data",equalTo("{\n    \"test\": \"value\"\n}"))
                .body("url", equalTo("https://postman-echo.com/patch"));

    }

    @Test
    public void deleteTest() {
        given()
                .baseUri("https://postman-echo.com/delete")
                .contentType(ContentType.TEXT)
                .body("{\n" +
                        "    \"test\": \"value\"\n" +
                        "}")
                .when()
                .delete()
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("data", equalTo("{\n    \"test\": \"value\"\n}"))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
