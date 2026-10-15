package dev.kevindubois.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class UserResourceTest {

    @Test
    void testGetUserEndpoint() {
        // Since findUser returns null probabilistically, status code must be either 200 or 404, never 500
        for (int i = 0; i < 20; i++) {
            given()
              .when().get("/api/user/123")
              .then()
                 .statusCode(anyOf(is(200), is(404)));
        }
    }
}
