package com.ufcg.psoft.mercadofacil.controller;

import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringBootTest;
import org.springframework.http.MediaType;

import static org.springframework.http.RequestEntity.put;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Teste do Controlador de Produtos")
public class ProdutoV1Controller {

    @Autowired
    MockMvc mockMvc;

    Produto produto;

    @BeforeEach
    void setUp(){
        produto = Produto.builder()
                .id(10L)
                .codigoBarra("7899137500104")
                .nome("Produto Dez")
                .fabricante("Empresa Dez")
                .preco(450.00)
                .build()
                );
    }
    @Test
    @DisplayName("Quando altero produto com nome válido")
    void alteroProdutoComNomeValido(){
        //Arrange
        produto.setNome("Chiclete");
        //Act
        produtoModificadoJSONString = mockMvc.perform(
                put(urlTemplate:"/produtos/" + 10))
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(produto))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();
        //Assert
        Produto produtoModificado = objectMapper.readValue(produtoModificadoJSONString, Produto produtoMapped);
        assertEquals(expected:"Chiclete", produtoModificado.getNome());
    }
}
