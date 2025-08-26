package br.futurodev.jmt.m2s09.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record PedidoRespostaDto(
        Long id,
        LocalDate dataCriacao,
        ClienteRespostaDto cliente,
        BigDecimal totalItens,
        BigDecimal totalDesconto,
        BigDecimal total,
        List<PedidoItemRespostaDto> itens
) {
}
