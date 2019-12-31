package br.com.bjsl.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Integer codigo;

    @NotNull(message = "O campo nome é obrigatório.")
    private String nome;

    @NotNull(message = "O campo descricao é obrigatório.")
    private String descricao;

    @NotNull(message = "O campo valor é obrigatório.")
    private BigDecimal valor;

    @NotNull(message = "O campo quantidade é obrigatório.")
    private Double quantidade;
}
