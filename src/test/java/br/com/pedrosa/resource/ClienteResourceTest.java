package br.com.pedrosa.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ClienteResourceTest {

    @Test
    public void testGetClientes() {
        given()
          .when().get("/cliente")
          .then()
             .statusCode(200);
    }

}