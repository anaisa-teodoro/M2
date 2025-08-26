package br.futurodev.jmt.m2s09.dtos;

import java.math.BigDecimal;

public record PedidoItemRespostaDto(
        Long id,
        ProdutoRespostaDto produto,
        Integer quantidade,
        BigDecimal valorUnitario,
        BigDecimal desconto,
        BigDecimal total
) {
}
