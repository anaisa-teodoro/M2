

public class Disco {
    private String titulo;
    private Genero genero;
    private boolean ativo;

    public Disco(String titulo, Genero genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.ativo = true;
    }

    public void inativar() {
        this.ativo = false;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public String getInfo() {
        return "Disco: " + titulo + "\n" + genero.getInfo() + "\nAtivo: " + ativo;
    }

    public String getTitulo() {
        return titulo;
    }
}
