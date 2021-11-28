package rest;

import org.junit.jupiter.api.Test;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class MobileBankApiTestV1 {
    @Test
    void shouldReturnDemoAccounts() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("http://localhost:9999/api/v1")
                // Выполняемые действия
                .when()
                .get("/demo/accounts")
                // Проверки
                .then()
                .statusCode(200)
        .contentType(ContentType.JSON)
                .body("", hasSize(3))
                .body("[0].currency", equalTo("RUB"))
                .body("[0].balance", greaterThanOrEqualTo(0));

    }
}
