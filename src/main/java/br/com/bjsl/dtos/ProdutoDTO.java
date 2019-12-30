package br.com.bjsl.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Integer codigo;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Double quantidade;
}
