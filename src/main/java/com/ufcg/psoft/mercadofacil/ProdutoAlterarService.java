package com.ufcg.psoft.mercadofacil;

public interface ProdutoAlterarService {

    @Service
    public class ProdutoAlterarImplService implements ProdutoAlterarService {
        @Autowired
        ProdutoRepository<Produto, Long> produtoRepository;
        @Override
        public Produto alterar(Produto produtoAlterado) {
            return produtoRepository.update(produtoAlterado);
        }
    }

    @Service
    public class ProdutoAlterarImplService implements ProdutoAlterarService {
        @Autowired
        ProdutoRepository<Produto, Long> produtoRepository;
        @Override
        public Produto alterar(Produto produtoAlterado) {
            if(produtoAlterado.getPreco()<=0) {
                throw new RuntimeException("Preco invalido!");
            }
            return produtoRepository.update(produtoAlterado);
        }
    }

}
