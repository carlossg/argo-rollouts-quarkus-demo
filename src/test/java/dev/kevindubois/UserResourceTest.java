package dev.kevindubois;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class UserResourceTest {

    @Test
    void testGetUserEndpointNoNPE() {
        // Call multiple times to ensure both null and non-null branches in findUser work without NPE
        for (int i = 0; i < 50; i++) {
            Response response = given()
              .when().get("/api/user/user" + i);
            int statusCode = response.getStatusCode();
            assertTrue(statusCode == 200 || statusCode == 404,
                "Status code should be either 200 or 404, but got " + statusCode);
        }
    }
}
