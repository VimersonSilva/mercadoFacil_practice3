package com.ufcg.psoft.mercadofacil.repository;

public interface ProdutoRepository {
    T find(Id Id);

    T save(T produto);

    public abstract
}
