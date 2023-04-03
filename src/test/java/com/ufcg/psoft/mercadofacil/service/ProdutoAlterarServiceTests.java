package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.ProdutoAlterarService;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@AutoConfigureMockMvc
@DisplayName("Testes para a alteração do Produto")
@SpringBootTest
public class ProdutoAlterarServiceTests {
    @Autowired
    ProdutoAlterarService driver;

    @MockBean
    ProdutoRepository<Produto, Long> produtoRepository;

    @InjectMocks
    ProdutoService produtoService;

    Produto produto;

    @BeforeEach
    void setUp(){
        Mockito.when(produtoRepository.find(10L))
                .thenReturn(Produto.builder())
                .id(10L)
                .codigoBarra("7899137500104")
                .nome("Produto Dez")
                .fabricante("Empresa Dez")
                .preco(450.00)
                .build()
                ;
        produto = produtoRepository.find(10L);
        Mockito.when(produtoRepository.update(produto))
                .thenreturn(Produto.builder()
                .id(10L)
                .codigoBarra("7899137500104")
                .nome("Nome Produto Alterado")
                .fabricante("Nome Fabricante Alterado")
                .preco(500.00)
                .build()
        );

        @Test
        @DisplayName("Quando altero o nome do produto com dados válidos")
        void alterarNomeDoProduto() {
            /* AAA Pattern */
            //Arrange
            produto.setNome("Nome Produto Alterado");
            //Act
            Produto resultado = driver.alterar(produto);
            //Assert
            assertEquals("Nome Produto Alterado",
                    resultado.getNome());
        }

        @Test
        @DisplayName("Quando o preço é menor ou igual a zero")
        void precoMenorIgualAZero() {
            //Arrange
            produto.setPreco(0.0);
            //Act
            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );
            //Assert
            assertEquals("Preco invalido!", thrown.getMessage());
        }


    }


}
