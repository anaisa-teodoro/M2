package br.futurodev.jmt.m2s09.servicos;

import br.futurodev.jmt.m2s09.dtos.CategoriaRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.CategoriaRespostaDto;
import br.futurodev.jmt.m2s09.entidades.CategoriaEntity;

import java.util.List;

public interface CategoriaService {

    // findAll
    List<CategoriaRespostaDto> buscar();

    // findById
    CategoriaRespostaDto buscarPorId(Long id);

    // findEntityById
    CategoriaEntity buscarEntidadePorId(Long id);

    // create
    CategoriaRespostaDto criar(CategoriaRequisicaoDto dto);

    // update
    CategoriaRespostaDto alterar(Long id, CategoriaRequisicaoDto dto);

    // delete
    void excluir(Long id);

}
