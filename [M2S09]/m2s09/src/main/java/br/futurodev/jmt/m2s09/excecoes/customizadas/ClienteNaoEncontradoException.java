package br.futurodev.jmt.m2s09.excecoes.customizadas;

public class ClienteNaoEncontradoException extends NaoEncontradoException {
    private static final String NOME_ENTIDADE = "cliente";

    public ClienteNaoEncontradoException() {
        super(NOME_ENTIDADE);
    }

    public ClienteNaoEncontradoException(Long id) {
        super(NOME_ENTIDADE, id);
    }

}
