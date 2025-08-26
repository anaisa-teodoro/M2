package br.futurodev.jmt.m2s09.mapeadores;

import br.futurodev.jmt.m2s09.dtos.PedidoItemRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.PedidoItemRespostaDto;
import br.futurodev.jmt.m2s09.dtos.PedidoRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.PedidoRespostaDto;
import br.futurodev.jmt.m2s09.entidades.PedidoEntity;
import br.futurodev.jmt.m2s09.entidades.PedidoItemEntity;

import java.util.List;

public class PedidoMapper {

    private PedidoMapper() {}

    public static PedidoRespostaDto toDto(PedidoEntity entidade) {
        return new PedidoRespostaDto(
                entidade.getId(),
                entidade.getDataCriacao(),
                ClienteMapper.toDto(entidade.getCliente()),
                entidade.getTotalItens(),
                entidade.getTotalDesconto(),
                entidade.getTotal(),
                toDto(entidade.getItens())
        );
    }

    public static List<PedidoItemRespostaDto> toDto(List<PedidoItemEntity> entidades) {
        return entidades.stream().map(PedidoMapper::toDto).toList();
    }

    public static PedidoItemRespostaDto toDto(PedidoItemEntity entidade) {
        return new PedidoItemRespostaDto(
                entidade.getId(),
                ProdutoMapper.toDto(entidade.getProduto()),
                entidade.getQuantidade(),
                entidade.getValorUnitario(),
                entidade.getDesconto(),
                entidade.getTotal()
        );
    }

    public static void toEntidade(
            PedidoEntity entidade,
            PedidoRequisicaoDto dto
    ) {
        entidade.setItens(
                dto.itens().stream().map(
                        (item) -> toEntidade(entidade, item)
                ).toList()
        );
    }

    public static PedidoItemEntity toEntidade(
            PedidoEntity pedido,
            PedidoItemRequisicaoDto dto
    ) {
        return PedidoItemEntity.builder()
                .pedido(pedido)
                .quantidade(dto.quantidade())
                .desconto(dto.desconto())
                .build();
    }

}
