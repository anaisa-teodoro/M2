package br.futurodev.jmt.m2s09.servicos;

import br.futurodev.jmt.m2s09.dtos.ClienteRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.ClienteRespostaDto;
import br.futurodev.jmt.m2s09.entidades.ClienteEntity;

import java.util.List;

public interface ClienteService {

    // findAll
    List<ClienteRespostaDto> buscar();

    // findById
    ClienteRespostaDto buscarPorId(Long id);

    // findEntityById
    ClienteEntity buscarEntidadePorId(Long id);

    // create
    ClienteRespostaDto criar(ClienteRequisicaoDto dto);

    // update
    ClienteRespostaDto alterar(Long id, ClienteRequisicaoDto dto);

    // delete
    void excluir(Long id);

    // activate
    void ativar(Long id);

    // deactivate
    void desativar(Long id);

}
