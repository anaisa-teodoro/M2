package br.futurodev.jmt.m2s09.excecoes.customizadas;

public class PedidoNaoEncontradoException extends NaoEncontradoException {
    private static final String NOME_ENTIDADE = "pedido";

    public PedidoNaoEncontradoException() {
        super(NOME_ENTIDADE);
    }

    public PedidoNaoEncontradoException(Long id) {
        super(NOME_ENTIDADE, id);
    }

}
