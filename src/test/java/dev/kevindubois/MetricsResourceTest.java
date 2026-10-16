package dev.kevindubois;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
class MetricsResourceTest {

    @Test
    void testGetStatusEndpoint() {
        given()
          .when().get("/api/status")
          .then()
             .statusCode(200)
             .body("status", notNullValue())
             .body("version", notNullValue());
    }
}
