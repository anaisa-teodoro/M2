

public class Genero {
    private String nome;
    private String descricao;

    public Genero(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getInfo() {
        return "Gênero: " + nome + "\nDescrição: " + descricao;
    }

    public String getNome() {
        return nome;
    }
}
