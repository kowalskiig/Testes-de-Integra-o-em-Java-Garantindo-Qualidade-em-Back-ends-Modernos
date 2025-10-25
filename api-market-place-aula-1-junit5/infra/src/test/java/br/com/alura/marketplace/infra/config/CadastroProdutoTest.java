package br.com.alura.marketplace.infra.config;

import br.com.alura.marketplace.application.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.checkerframework.checker.units.qual.N;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment =  RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
public class CadastroProdutoTest {

    @LocalServerPort
    Integer port; //Recupera o valor da porta.

    @Autowired
    ObjectMapper objectMapper;

    @DisplayName("Cadastro de produto")
    @Nested
    class CadastrarProduto {

        @DisplayName("Quando sucesso")
        @Nested
        class sucesso{


        }

        @DisplayName("Dado um produto com todos os campos")
        @Test
        void teste1(){

            // Dado
            var produto = criarProdutoDtoRequest()
                    .comTodosOsCampos();

            // Quando
            var resposta = RestAssured.given()
                    .log().all()
                    .header("Correlation-Id", "7cdbbac3-2444-4182-894d-")
                    .contentType(JSON)
                    .body(objectMapper.writeValueAsString(produto))
                    .post("/api/v1/produtos")
                    .then()
                    .log().all()
                    .extract()
                    .response();

            // Então
            assertThat(resposta.statusCode())
                    .isEqualTo(201);
        }
    }

}
