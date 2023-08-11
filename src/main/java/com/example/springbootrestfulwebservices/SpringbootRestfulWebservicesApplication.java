package com.example.springbootrestfulwebservices;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
         info = @Info(
                 title = "Spring boot User API Documentation",
                 version = "v1.0",
                 description = "Spring boot User API Documentation",
                 contact = @Contact(
                        name = "Juan Linares",
                        email = "jlinaresmedalla@gmail.com",
                        url = "https://www.linkedin.com/in/alvarolinaresmedalla/"
                 ),
                 license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0"
                 )
         ),
        externalDocs = @ExternalDocumentation(
                description = "Spring boot User API Documentation",
                url = "https://www.linkedin.com/in/alvarolinaresmedalla/"
        )
)
public class SpringbootRestfulWebservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
    }

}
