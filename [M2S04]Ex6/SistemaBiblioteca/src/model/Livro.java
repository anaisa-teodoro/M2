package model;

public class Livro {
    private final String isbn;
    private String titulo;
    private String autor;
    private boolean emprestado;

    private static int totalLivros = 0;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }


    public Livro(String isbn, String titulo, String autor){
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.emprestado = false;
        totalLivros++;
    }

    public String getIsbn(){
        return isbn;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public boolean isEmprestado(){
        return emprestado;
    }

    public void emprestar(){
        this.emprestado = true;
    }

    public void devolver(){
        this.emprestado = false;
    }

    public static int getTotalLivros(){
        return totalLivros;
    }


    public String gerarDescricao(String... informacoesAdicionais) {
        StringBuilder descricao = new StringBuilder();
        descricao.append(String.format("Livro: %s (ISBN: %s) por %s", titulo, isbn, autor));

        if (informacoesAdicionais.length > 0) {
            descricao.append("\nInformações Adicionais:");
            for (String informacao : informacoesAdicionais) {
                descricao.append("\n- ").append(informacao);
            }
        }

        return descricao.toString();

    }
}
