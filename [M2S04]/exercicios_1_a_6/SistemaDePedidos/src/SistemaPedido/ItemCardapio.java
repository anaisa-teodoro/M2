package SistemaPedido;

public class ItemCardapio {
    private String codigo;
    private String nome;
    private double preco;

    public ItemCardapio(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        setPreco(preco);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
        } else {
            System.out.println("Preço deve ser maior que zero.");
        }
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " | Nome: " + nome + " | Preço: R$ " + String.format("%.2f", preco);
    }
}
