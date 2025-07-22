package model;

public class Gato extends Animal {
    private boolean conviveComOutrosGatos;

    public Gato(String id, String nome, int idade, String condicaoSaude, String temperamento, String status, boolean conviveComOutrosGatos) {
        super(id, nome, "Gato", idade, condicaoSaude, temperamento, status);
        this.conviveComOutrosGatos = conviveComOutrosGatos;
    }

    @Override
    public String gerarRelatorio() {
        return super.gerarRelatorio() + String.format(" | Convive com outros gatos: %s",
                conviveComOutrosGatos ? "Sim" : "Não");
    }

    // Getters e Setters
    public boolean isConviveComOutrosGatos() { return conviveComOutrosGatos; }
    public void setConviveComOutrosGatos(boolean conviveComOutrosGatos) { this.conviveComOutrosGatos = conviveComOutrosGatos; }
}