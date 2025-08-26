package br.futurodev.jmt.m2s09.servicos;

import br.futurodev.jmt.m2s09.dtos.PedidoRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.PedidoRespostaDto;
import br.futurodev.jmt.m2s09.entidades.PedidoEntity;

import java.util.List;

public interface PedidoService {

    // findAll
    List<PedidoRespostaDto> buscar();

    // findById
    PedidoRespostaDto buscarPorId(Long id);

    // create
    PedidoRespostaDto criar(PedidoRequisicaoDto dto);

}
