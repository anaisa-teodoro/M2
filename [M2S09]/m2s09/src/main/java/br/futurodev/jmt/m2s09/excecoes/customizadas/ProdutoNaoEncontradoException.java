package br.futurodev.jmt.m2s09.excecoes.customizadas;

public class ProdutoNaoEncontradoException extends NaoEncontradoException {
    private static final String NOME_ENTIDADE = "produto";

    public ProdutoNaoEncontradoException() {
        super(NOME_ENTIDADE);
    }

    public ProdutoNaoEncontradoException(Long id) {
        super(NOME_ENTIDADE, id);
    }

}
