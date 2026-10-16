package dev.kevindubois;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
class MetricsResourceTest {

    @Test
    void testStatusEndpoint() {
        given()
          .when().get("/api/status")
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON)
             .body("version", notNullValue())
             .body("status", notNullValue());
    }

    @Test
    void testScenarioEndpoint() {
        given()
          .when().get("/api/scenario")
          .then()
             .statusCode(200)
             .contentType(ContentType.JSON)
             .body("version", notNullValue());
    }
}
