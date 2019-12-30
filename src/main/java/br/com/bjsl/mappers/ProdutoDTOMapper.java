package br.com.bjsl.mappers;

import br.com.bjsl.dtos.ProdutoDTO;
import br.com.bjsl.models.Produto;

public class ProdutoDTOMapper {
    public static ProdutoDTO mapFrom(Produto produto) {
        return ProdutoDTO.builder()
                .codigo(produto.getCodigo())
                .nome(produto.getNome())
                .descricao(produto.getDescricao())
                .quantidade(produto.getQuantidade())
                .valor(produto.getValor())
                .build();
    }
}
