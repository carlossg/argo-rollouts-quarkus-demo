package dev.kevindubois.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class UserResourceTest {

    @Test
    void testGetUser() {
        // Repeatedly call /api/user/123 to ensure both 200 (user found) and 404 (user null) paths work without 500 NPE
        for (int i = 0; i < 20; i++) {
            given()
                .when().get("/api/user/123")
                .then()
                    .statusCode(anyOf(is(200), is(404)));
        }
    }
}
