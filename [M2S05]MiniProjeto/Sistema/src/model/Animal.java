package model;

import interfaces.Validavel;
import interfaces.Relatorio;

public abstract class Animal implements Validavel, Relatorio {
    protected String id;
    protected String nome;
    protected String especie;
    protected int idade;
    protected String condicaoSaude;
    protected String temperamento;
    protected String status; // disponível, indisponível, adotado

    public Animal(String id, String nome, String especie, int idade, String condicaoSaude, String temperamento, String status) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.condicaoSaude = condicaoSaude;
        this.temperamento = temperamento;
        this.status = status;
    }

    @Override
    public boolean validar() {
        return "disponível".equalsIgnoreCase(status) && !"doente".equalsIgnoreCase(condicaoSaude);
    }

    @Override
    public String gerarRelatorio() {
        return String.format("ID: %s | Nome: %s | Espécie: %s | Idade: %d anos | Saúde: %s | Temperamento: %s | Status: %s",
                id, nome, especie, idade, condicaoSaude, temperamento, status);
    }

    // Getters e Setters
    public String getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecie() { return especie; }
    public int getIdade() { return idade; }
    public String getCondicaoSaude() { return condicaoSaude; }
    public String getTemperamento() { return temperamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
