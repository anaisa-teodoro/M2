package SistemaPedido;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private String nome;
    private List<ItemCardapio> cardapio;

    private static int totalItens = 0;
    private static int totalRestaurantes = 0;

    public Restaurante(String nome) {
        this.nome = nome;
        this.cardapio = new ArrayList<>();
        totalRestaurantes++;
    }

    public void adicionarItem(ItemCardapio item) {
        cardapio.add(item);
        totalItens++;
    }

    public void listarCardapio() {
        if (cardapio.isEmpty()) {
            System.out.println("Cardápio vazio.");
        } else {
            for (ItemCardapio item : cardapio) {
                System.out.println(item);
            }
        }
    }

    public List<ItemCardapio> buscarItens(String... codigos) {
        List<ItemCardapio> encontrados = new ArrayList<>();
        for (String codigo : codigos) {
            for (ItemCardapio item : cardapio) {
                if (item.getCodigo().equalsIgnoreCase(codigo)) {
                    encontrados.add(item);
                    break;
                }
            }
        }
        return encontrados;
    }

    public double fazerPedido(String... codigos) {
        double total = 0;
        for (String codigo : codigos) {
            boolean achou = false;
            for (ItemCardapio item : cardapio) {
                if (item.getCodigo().equalsIgnoreCase(codigo)) {
                    total += item.getPreco();
                    achou = true;
                    break;
                }
            }
            if (!achou) {
                System.out.println("Item com código " + codigo + " não encontrado.");
            }
        }
        return total;
    }

    public static int getTotalItens() {
        return totalItens;
    }

    public static int getTotalRestaurantes() {
        return totalRestaurantes;
    }
}
