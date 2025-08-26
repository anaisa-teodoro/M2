package br.futurodev.jmt.m2s09.excecoes.customizadas;

public class CategoriaNaoEncontradaException extends NaoEncontradoException {
    private static final String NOME_ENTIDADE = "categoria";

    public CategoriaNaoEncontradaException() {
        super(NOME_ENTIDADE);
    }

    public CategoriaNaoEncontradaException(Long id) {
        super(NOME_ENTIDADE, id);
    }

}
