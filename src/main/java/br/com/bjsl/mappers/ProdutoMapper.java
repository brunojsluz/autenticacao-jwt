package br.com.bjsl.mappers;

import br.com.bjsl.dtos.ProdutoDTO;
import br.com.bjsl.models.Produto;

public class ProdutoMapper {
    public static Produto mapFrom(ProdutoDTO produtoDTO) {
        return Produto.builder()
                .codigo(produtoDTO.getCodigo())
                .descricao(produtoDTO.getDescricao())
                .nome(produtoDTO.getNome())
                .quantidade(produtoDTO.getQuantidade())
                .valor(produtoDTO.getValor())
                .build();
    }
}
