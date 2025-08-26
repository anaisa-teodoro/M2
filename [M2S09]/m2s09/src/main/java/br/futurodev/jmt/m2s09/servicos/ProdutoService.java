package br.futurodev.jmt.m2s09.servicos;

import br.futurodev.jmt.m2s09.dtos.ProdutoRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.ProdutoRespostaDto;
import br.futurodev.jmt.m2s09.entidades.ProdutoEntity;

import java.util.List;

public interface ProdutoService {

    // findAll
    List<ProdutoRespostaDto> buscar();

    // findById
    ProdutoRespostaDto buscarPorId(Long id);

    // findEntityById
    ProdutoEntity buscarEntidadePorId(Long id);

    // create
    ProdutoRespostaDto criar(ProdutoRequisicaoDto dto);

    // update
    ProdutoRespostaDto alterar(Long id, ProdutoRequisicaoDto dto);

    // delete
    void excluir(Long id);

}
