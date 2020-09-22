package br.com.pedrosa.config;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        info = @Info(
                title="API de Clientes  Quarkus",
                version = "1.0.1",
                contact = @Contact(
                        name = "API Clientes",
                        url = "http://www.thebestdevs.com.br",
                        email = "bito.pedrosa@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"))
)
public class OpenApiConfig extends Application {
}
