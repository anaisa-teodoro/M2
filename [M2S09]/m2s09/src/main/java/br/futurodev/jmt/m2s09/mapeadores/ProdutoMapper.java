package br.futurodev.jmt.m2s09.mapeadores;

import br.futurodev.jmt.m2s09.dtos.ProdutoRequisicaoDto;
import br.futurodev.jmt.m2s09.dtos.ProdutoRespostaDto;
import br.futurodev.jmt.m2s09.entidades.ProdutoEntity;

public class ProdutoMapper {

    private ProdutoMapper() {}

    public static ProdutoRespostaDto toDto(ProdutoEntity entidade) {
        return new ProdutoRespostaDto(
                entidade.getId(),
                entidade.getNome(),
                entidade.getDescricao(),
                CategoriaMapper.toDto(entidade.getCategoria()),
                entidade.getPreco()
        );
    }

    public static void toEntidade(
            ProdutoEntity entidade,
            ProdutoRequisicaoDto dto
    ) {
        entidade.setNome(dto.nome());
        entidade.setDescricao(dto.descricao());
        entidade.setPreco(dto.preco());
    }

}
