package br.futurodev.jmt.m2s09.dtos;

import java.math.BigDecimal;

public record PedidoItemRequisicaoDto(
        Long produtoId,
        Integer quantidade,
        BigDecimal desconto // Provisório
) {
}
