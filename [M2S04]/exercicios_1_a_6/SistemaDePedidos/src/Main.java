import SistemaPedido.ItemCardapio;
import SistemaPedido.Restaurante;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Restaurante restaurante = new Restaurante("Restaurante Exemplo");

        int opcao;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar item");
            System.out.println("2. Ver cardápio");
            System.out.println("3. Fazer pedido");
            System.out.println("4. Ver estatísticas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    restaurante.adicionarItem(new ItemCardapio(codigo, nome, preco));
                    break;

                case 2:
                    restaurante.listarCardapio();
                    break;

                case 3:
                    System.out.print("Digite os códigos dos itens (separados por espaço): ");
                    String[] codigos = scanner.nextLine().split(" ");
                    double total = restaurante.fazerPedido(codigos);
                    System.out.printf("Total do pedido: R$ %.2f%n", total);
                    break;

                case 4:
                    System.out.println("Total de itens: " + Restaurante.getTotalItens());
                    System.out.println("Total de restaurantes: " + Restaurante.getTotalRestaurantes());
                    break;

                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
