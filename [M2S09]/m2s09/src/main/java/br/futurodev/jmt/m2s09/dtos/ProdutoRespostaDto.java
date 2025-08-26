package br.futurodev.jmt.m2s09.dtos;

import java.math.BigDecimal;

public record ProdutoRespostaDto(
        Long id,
        String nome,
        String descricao,
        CategoriaRespostaDto categoria,
        BigDecimal preco
) {
}
