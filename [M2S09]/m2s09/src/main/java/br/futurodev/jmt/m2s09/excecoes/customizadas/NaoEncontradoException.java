package br.futurodev.jmt.m2s09.excecoes.customizadas;

public abstract class NaoEncontradoException extends RuntimeException {
    protected NaoEncontradoException() {
        super("Recurso não encontrado");
    }

    protected NaoEncontradoException(String nomeEntidade) {
        super(nomeEntidade + " não encontrado");
    }

    protected NaoEncontradoException(String nomeEntidade, Long id) {
        super("Não foi possível encontrar " + nomeEntidade + " com id: " + id);
    }
}
