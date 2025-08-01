package model;

import interfaces.Validavel;
import interfaces.Relatorio;

public class Adotante implements Validavel, Relatorio {
    private String nome;
    private String cpf;
    private String endereco;
    private String preferencias;
    private boolean habilitado;

    public Adotante(String nome, String cpf, String endereco, String preferencias) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.preferencias = preferencias;
        this.habilitado = true;
    }

    @Override
    public boolean validar() {
        return !habilitado;
    }

    @Override
    public String gerarRelatorio() {
        return String.format("Nome: %s | CPF: %s | Endereço: %s | Preferências: %s | Status: %s",
                nome, cpf, endereco, preferencias, habilitado ? "Habilitado" : "Desabilitado");
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getEndereco() { return endereco; }
    public String getPreferencias() { return preferencias; }
    public boolean isHabilitado() { return habilitado; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setPreferencias(String preferencias) { this.preferencias = preferencias; }
    public void setHabilitado(boolean habilitado) { this.habilitado = habilitado; }
}