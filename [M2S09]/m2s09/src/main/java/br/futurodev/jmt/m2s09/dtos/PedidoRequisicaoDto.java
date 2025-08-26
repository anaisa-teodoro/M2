package br.futurodev.jmt.m2s09.dtos;

import java.util.List;

public record PedidoRequisicaoDto(
        Long clienteId,
        List<PedidoItemRequisicaoDto> itens
) {
}
