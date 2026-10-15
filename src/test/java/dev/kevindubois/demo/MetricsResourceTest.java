package dev.kevindubois.demo;

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
             .body("version", notNullValue())
             .body("status", notNullValue());
    }

    @Test
    void testGetScenarioEndpoint() {
        given()
          .when().get("/api/scenario")
          .then()
             .statusCode(200)
             .body("scenario", notNullValue());
    }
}
