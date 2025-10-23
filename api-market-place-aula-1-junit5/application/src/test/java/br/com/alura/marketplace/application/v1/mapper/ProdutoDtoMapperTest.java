package br.com.alura.marketplace.application.v1.mapper;

import br.com.alura.marketplace.application.v1.dto.FotoDto;
import br.com.alura.marketplace.application.v1.dto.ProdutoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

import static br.com.alura.marketplace.domain.entity.Produto.Status.AVAILABLE;
import static org.assertj.core.api.Assertions.assertThat;

class ProdutoDtoMapperTest {

    ProdutoDtoMapper mapper = Mappers.getMapper(ProdutoDtoMapper.class);



    @DisplayName("Converter um ProdutoDto.Requet")
    @Nested
    class Converter {

        @DisplayName("Então deve começar com sucesso")
        @Nested
        class Sucesso{

            @DisplayName("Dado um Produto.Dto.Request com Todos os campos")
            @Test
            void teste1(){
                //Dado
                var dto = ProdutoDto.Request.builder()
                        .nome("Produto Teste")
                        .categoria("Categoria 1")
                        .status(AVAILABLE)
                        .descricao("Descricao do Produto Teste")
                        .valor(new BigDecimal("1.99"))
                        .foto(FotoDto.Request.builder()
                                .fileName("file-name-1.jpg")
                                .base64("Y2Fyb2xpbmEgSGVycmVyYQ==")
                                .build())
                        .tag("tag-1")
                        .build();

                //Quando
                var atual = mapper.converter(dto);

                //Então
                assertThat(atual.getNome())
                        .isEqualTo("Produto Teste");

                assertThat(atual.getCategoria())
                        .isEqualTo("Categoria 1");


            }

        }
    }
}