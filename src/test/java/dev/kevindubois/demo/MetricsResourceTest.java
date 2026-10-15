package dev.kevindubois.demo;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class MetricsResourceTest {

    @Test
    void testGetStatusNormal() {
        given()
            .when().get("/api/status")
            .then()
                .statusCode(200)
                .body("status", notNullValue());
    }
}
