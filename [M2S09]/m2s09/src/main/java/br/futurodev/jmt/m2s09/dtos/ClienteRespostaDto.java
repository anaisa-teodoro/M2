package br.futurodev.jmt.m2s09.dtos;

public record ClienteRespostaDto(
        Long id,
        String nome,
        String documento,
        Boolean ativo
) {
}
