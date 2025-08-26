package br.futurodev.jmt.m2s09.mapeadores;

import br.futurodev.jmt.m2s09.dtos.CategoriaRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.CategoriaRespostaDto;
import br.futurodev.jmt.m2s09.entidades.CategoriaEntity;

public class CategoriaMapper {

    private CategoriaMapper() {}

    public static CategoriaRespostaDto toDto(CategoriaEntity entidade) {
        return new CategoriaRespostaDto(
                entidade.getId(),
                entidade.getNome()
        );
    }

    public static void toEntidade(
            CategoriaEntity entidade,
            CategoriaRequisicaoDto dto
    ) {
        entidade.setNome(dto.nome());
    }

}
