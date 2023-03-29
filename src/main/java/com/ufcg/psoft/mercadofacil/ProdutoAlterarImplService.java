package com.ufcg.psoft.mercadofacil;

import com.ufcg.psoft.mercadofacil.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoAlterarImplService implements ProdutoAlterarService {
    @Autowired
    ProdutoRepository<Produto, Long> produtoRepository;

    @Override
    public Produto alterar(Produto produtoAlterado) {
        if(produtoAlterado.getPreco() <= 0){
            throw new RunTimeException("Preco invalido!");
        }
        return produtoRepository.update(produtoAlterado);
    }
}

