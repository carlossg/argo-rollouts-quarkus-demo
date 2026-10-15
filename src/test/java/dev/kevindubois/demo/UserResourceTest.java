package dev.kevindubois.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

@QuarkusTest
class UserResourceTest {

    @Test
    void testGetUserEndpoint() {
        // Since findUser may return null ~20% of the time,
        // status code should be either 200 (OK) or 404 (Not Found), never 500 (NPE).
        for (int i = 0; i < 20; i++) {
            given()
              .when().get("/api/user/123")
              .then()
                 .statusCode(anyOf(is(200), is(404)));
        }
    }
}
