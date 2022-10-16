package dio.web.api.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contact() {
        return new Contact(
                "Leona Ceschin",
                "http://seusite.com.br",
                "email@email.com");
    }

    private ApiInfoBuilder informacaoApi() {
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Titulo  - Rest API");
        apiInfoBuilder.description("API exermplo de uso de Springboot REST API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licença - Sua Empresa");
        apiInfoBuilder.licenseUrl("http://seusite.com.br");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;

    }

    @Bean
    public Docket detalheApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
            .select()
            .apis(RequestHandlerSelectors.basePackage("dio.web.api.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.informacaoApi().build())
            .consumes(new HashSet<String>(Arrays.asList("application/json")))
            .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;

    }

}
