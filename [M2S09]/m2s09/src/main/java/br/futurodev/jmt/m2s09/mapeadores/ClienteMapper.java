package br.futurodev.jmt.m2s09.mapeadores;

import br.futurodev.jmt.m2s09.dtos.ClienteRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.ClienteRespostaDto;
import br.futurodev.jmt.m2s09.entidades.ClienteEntity;

public class ClienteMapper {

    private ClienteMapper() {}

    public static ClienteRespostaDto toDto(ClienteEntity entidade) {
        return new ClienteRespostaDto(
                entidade.getId(),
                entidade.getNome(),
                entidade.getDocumento(),
                entidade.getAtivo()
        );
    }

    public static void toEntidade(
            ClienteEntity entidade,
            ClienteRequisicaoDto dto
    ) {
        entidade.setNome(dto.nome());
        entidade.setDocumento(dto.documento());
    }

}
