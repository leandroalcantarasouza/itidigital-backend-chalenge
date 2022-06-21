package com.itidigital.backendchallenge.controller;

import com.itidigital.backendchallenge.BackendchallengeApplication;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.payload.RequestFieldsSnippet;
import org.springframework.restdocs.payload.ResponseFieldsSnippet;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;


@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest(classes = BackendchallengeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ValidacaoCredenciaisResourceItTest {

    private RequestSpecification documentationSpec;

    @BeforeEach
    public void setUp(RestDocumentationContextProvider restDocumentation) {
        this.documentationSpec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(restDocumentation))
                .build();
    }

    @LocalServerPort
    private void initRestAssured(final int localPort) {
        RestAssured.port = localPort;
    }

    @Test
    public void devePermitirSenhaValida() {
        given(this.documentationSpec)
                .filter(document("validacao-senha-sucesso", documentacaoCamposEntrada(), documentacaoCamposSaida()))
                .contentType(ContentType.JSON)
                .body(ValidacaoRequestObjectMother.criarSenhaValida())
                .when()
                .post("/api/v1/credenciais/validacao")
                .then()
                .statusCode(equalTo(200))
                .and()
                .body("resultadoValidacao", equalTo(Boolean.TRUE));
    }

    @Test
    public void deveValidarSenhaContendoEspacoEmBranco() {
        given(this.documentationSpec)
                .filter(document("validacao-senha-erro", documentacaoCamposEntrada(), documentacaoCamposSaida()))
                .contentType(ContentType.JSON)
                .body(ValidacaoRequestObjectMother.criarSenhaComEspacoEmBranco())
                .when()
                .post("/api/v1/credenciais/validacao")
                .then()
                .statusCode(equalTo(412))
                .and()
                .body("resultadoValidacao", equalTo(Boolean.FALSE));
    }

    @Test
    public void deveValidarSenhaContendCaracterRepetido() {
        given()
                .contentType(ContentType.JSON)
                .body(ValidacaoRequestObjectMother.criarSenhaComCaracterRepetido())
                .when()
                .post("/api/v1/credenciais/validacao")
                .then()
                .statusCode(equalTo(412))
                .and()
                .body("resultadoValidacao", equalTo(Boolean.FALSE));
    }

    @Test
    public void deveValidarSenhaFaltandoCaracterMaiusculo() {
        given()
                .contentType(ContentType.JSON)
                .body(ValidacaoRequestObjectMother.criarSenhaFaltandoCaracterMaiusculo())
                .when()
                .post("/api/v1/credenciais/validacao")
                .then()
                .statusCode(equalTo(412))
                .and()
                .body("resultadoValidacao", equalTo(Boolean.FALSE));
    }

    @Test
    public void deveValidarSenhaFaltandoCaracterMinusculo() {
        given()
                .contentType(ContentType.JSON)
                .body(ValidacaoRequestObjectMother.criarSenhaFaltandoCaracterMinusculo())
                .when()
                .post("/api/v1/credenciais/validacao")
                .then()
                .statusCode(equalTo(412))
                .and()
                .body("resultadoValidacao", equalTo(Boolean.FALSE));
    }

    @Test
    public void deveValidarSenhaComQuantidadeCaractereMenorQueMinimo() {
        given()
                .contentType(ContentType.JSON)
                .body(ValidacaoRequestObjectMother.criarSenhaMenosCaracteresQueOMinimo())
                .when()
                .post("/api/v1/credenciais/validacao")
                .then()
                .statusCode(equalTo(412))
                .and()
                .body("resultadoValidacao", equalTo(Boolean.FALSE));
    }

    @Test
    public void deveValidarSenhaFaltandoCaracterEspecial() {
        given()
                .contentType(ContentType.JSON)
                .body(ValidacaoRequestObjectMother.criarSenhaFaltandoCaracterEspecial())
                .when()
                .post("/api/v1/credenciais/validacao")
                .then()
                .statusCode(equalTo(412))
                .and()
                .body("resultadoValidacao", equalTo(Boolean.FALSE));
    }

    @Test
    public void deveValidarSenhaFaltandoDigito() {
        given()
                .contentType(ContentType.JSON)
                .body(ValidacaoRequestObjectMother.criarSenhaFaltandoDigito())
                .when()
                .post("/api/v1/credenciais/validacao")
                .then()
                .statusCode(equalTo(412))
                .and()
                .body("resultadoValidacao", equalTo(Boolean.FALSE));
    }

    @Test
    public void deveValidarSenhaVazia() {
        given()
                .contentType(ContentType.JSON)
                .when()
                .body(ValidacaoRequestObjectMother.criarSenhaVazia())
                .post("/api/v1/credenciais/validacao")
                .then()
                .statusCode(equalTo(412))
                .and()
                .body("resultadoValidacao", equalTo(Boolean.FALSE));
    }

    private RequestFieldsSnippet documentacaoCamposEntrada() {
        return requestFields(
                fieldWithPath("senha").description("Senha a ser enviada pela api")
        );
    }

    private ResponseFieldsSnippet documentacaoCamposSaida() {
        return responseFields(
                fieldWithPath("resultadoValidacao").description("Resultado da validação em formato booleano")
        );
    }
}
