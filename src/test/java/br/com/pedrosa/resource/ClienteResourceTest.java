package br.com.pedrosa.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


@QuarkusTest
public class ClienteResourceTest {

    @Test
    public void testGetClientes() {
        given()
          .when().get("/clientes")
          .then()
             .statusCode(401);
    }

}