package br.com.alura.marketplace.domain.usecase;

import br.com.alura.marketplace.domain.entity.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CadastroProdutoUseCaseTest {


    private CadastroProdutoUseCase cadastroProdutoUseCase;

    @BeforeEach
    void setUp(){
        cadastroProdutoUseCase = new CadastroProdutoUseCase(
                null,
                null,
                null,
                null);
    }


    @DisplayName("Quando cadastrar produto")
    @Nested
    class Cadastrar {

            @DisplayName("Então deve começar com sucesso")
            @Nested
            class Sucesso{

                    @DisplayName("Dado um produto com todos os campos")
                    @Test
                    void teste1(){
                        //Dado

                        var produto = Produto.builder()
                                .nome("Nome 1")
                                .build();
                        //Quando

                        var atual = cadastroProdutoUseCase.cadastrar(produto);

                        //Então


                    }

            }
    }

}




