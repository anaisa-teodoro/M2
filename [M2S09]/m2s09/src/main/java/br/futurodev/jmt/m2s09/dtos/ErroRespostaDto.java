package br.futurodev.jmt.m2s09.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErroRespostaDto {

    private String codigo;
    private String mensagem;
    private String classe;

}
