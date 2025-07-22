package model;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Adocao {
    private Adotante adotante;
    private Animal animalAdotado;
    private LocalDateTime data;
    private boolean termoAssinado;

    public Adocao(Adotante adotante, Animal animalAdotado) {
        this.adotante = adotante;
        this.animalAdotado = animalAdotado;
        this.data = LocalDateTime.now();
        this.termoAssinado = false;
    }

    public void assinarTermo() {
        this.termoAssinado = true;
    }

    public String gerarRelatorio() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String status = termoAssinado ? "Finalizada" : "Pendente";

        return String.format("📋 ADOÇÃO %s\n" +
                        "👤 Adotante: %s (CPF: %s)\n" +
                        "🐾 Animal: %s (ID: %s)\n" +
                        "📅 Data: %s\n" +
                        "📝 Termo Assinado: %s",
                status, adotante.getNome(), adotante.getCpf(),
                animalAdotado.getNome(), animalAdotado.getId(),
                data.format(formatter), termoAssinado ? "Sim" : "Não");
    }

    // Getters
    public Adotante getAdotante() { return adotante; }
    public Animal getAnimalAdotado() { return animalAdotado; }
    public LocalDateTime getData() { return data; }
    public boolean isTermoAssinado() { return termoAssinado; }
}
