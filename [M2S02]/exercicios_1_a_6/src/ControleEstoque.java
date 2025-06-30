//[M2S02] Ex 1 - 6

import java.util.Scanner;

class Produto {
    String nome;
    double preco;
    int quantidade;

    Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    double valorTotal() {
        return preco * quantidade;
    }
}

public class ControleEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Produto[] produtos = {
                new Produto("Tomates", 1.00, 10),
                new Produto("Batatas", 2.00, 10),
                new Produto("Cebolas", 1.00, 10)
        };

        int opcao;
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("[1] Venda");
            System.out.println("[2] Reposição");
            System.out.println("[3] Relatório");
            System.out.println("[4] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    realizarVenda(produtos, scanner);
                    break;
                case 2:
                    realizarReposicao(produtos, scanner);
                    break;
                case 3:
                    gerarRelatorio(produtos);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }

    static void realizarVenda(Produto[] produtos, Scanner scanner) {
        int produtoIndex = escolherProduto(produtos, scanner);
        System.out.print("Quantidade a vender: ");
        int quantidade = scanner.nextInt();

        if (quantidade <= produtos[produtoIndex].quantidade) {
            produtos[produtoIndex].quantidade -= quantidade;
            System.out.println("Venda realizada com sucesso!");
        } else {
            System.out.println("Erro: Estoque insuficiente.");
        }
    }

    static void realizarReposicao(Produto[] produtos, Scanner scanner) {
        int produtoIndex = escolherProduto(produtos, scanner);
        System.out.print("Quantidade a repor: ");
        int quantidade = scanner.nextInt();

        produtos[produtoIndex].quantidade += quantidade;
        System.out.println("Reposição realizada com sucesso!");
    }

    static int escolherProduto(Produto[] produtos, Scanner scanner) {
        System.out.println("Escolha o produto:");
        for (int i = 0; i < produtos.length; i++) {
            System.out.printf("[%d] %s\n", i + 1, produtos[i].nome);
        }
        int escolha = scanner.nextInt();
        return escolha - 1;
    }

    static void gerarRelatorio(Produto[] produtos) {
        System.out.println("\n=== RELATÓRIO ===");
        double totalEstoque = 0;
        for (Produto p : produtos) {
            double valorProduto = p.valorTotal();
            totalEstoque += valorProduto;
            System.out.printf("%s | Estoque: %d | Unidade: R$%.2f | Valor: R$%.2f\n",
                    p.nome, p.quantidade, p.preco, valorProduto);
        }
        System.out.printf("TOTAL EM ESTOQUE: R$%.2f\n", totalEstoque);
    }
}
