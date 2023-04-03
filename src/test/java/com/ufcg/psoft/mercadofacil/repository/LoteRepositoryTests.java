package com.ufcg.psoft.mercadofacil.repository;


import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Testes do repositorio Lote")
public class LoteRepositoryTests {

    @Autowired
    LoteRepository<Lote, Long> driver;

    Lote lote;
    Produto produto

}
