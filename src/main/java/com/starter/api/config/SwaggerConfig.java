package com.starter.api.config;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import org.reflections.Reflections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.core.config.Projection;
import org.springframework.http.HttpStatus;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2WebMvc
@Import({SpringDataRestConfiguration.class, BeanValidatorPluginsConfiguration.class})
public class SwaggerConfig {
    @Bean
    public Docket api() {

        TypeResolver typeResolver = new TypeResolver();
        List<ResolvedType> additionalModels = new ArrayList<>();
        Reflections ref = new Reflections("com.starter.api.models.projections");
        for (Class<?> cl : ref.getTypesAnnotatedWith(Projection.class)) {
            additionalModels.add(typeResolver.resolve(cl));
        }
        //additionalModels.add(typeResolver.resolve(RestApiError.class));

        return new Docket(DocumentationType.SWAGGER_2)
                .additionalModels(typeResolver.resolve(HttpStatus.class), additionalModels.toArray(new ResolvedType[0]))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/**"))
                .build();
    }
}
