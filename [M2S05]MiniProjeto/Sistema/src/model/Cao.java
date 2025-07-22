package model;


public class Cao extends Animal {
    private String porte;
    private boolean necessitaPasseio;

    public Cao(String id, String nome, int idade, String condicaoSaude, String temperamento, String status, String porte, boolean necessitaPasseio) {
        super(id, nome, "Cão", idade, condicaoSaude, temperamento, status);
        this.porte = porte;
        this.necessitaPasseio = necessitaPasseio;
    }

    @Override
    public String gerarRelatorio() {
        return super.gerarRelatorio() + String.format(" | Porte: %s | Necessita Passeio: %s",
                porte, necessitaPasseio ? "Sim" : "Não");
    }

    // Getters e Setters
    public String getPorte() { return porte; }
    public boolean isNecessitaPasseio() { return necessitaPasseio; }
    public void setPorte(String porte) { this.porte = porte; }
    public void setNecessitaPasseio(boolean necessitaPasseio) { this.necessitaPasseio = necessitaPasseio; }
}
