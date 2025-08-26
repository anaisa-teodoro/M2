package br.futurodev.jmt.m2s09.dtos;

import java.math.BigDecimal;

public record ProdutoRequisicaoDto(
        String nome,
        String descricao,
        Long categoriaId,
        BigDecimal preco
) {
}
