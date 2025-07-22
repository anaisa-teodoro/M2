import service.GestaoAdotantes;
import service.GestaoAnimais;
import service.GestaoAdocoes;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GestaoAdotantes gestaoAdotantes = new GestaoAdotantes();
        GestaoAnimais gestaoAnimais = new GestaoAnimais();
        GestaoAdocoes gestaoAdocoes = new GestaoAdocoes();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n--- MENU PRINCIPAL ---");
                System.out.println("[1] Gestão de Adotantes");
                System.out.println("[2] Gestão de Animais");
                System.out.println("[3] Gestão de Adoções");
                System.out.println("[4] Sair");
                System.out.print("Escolha: ");

                try {
                    int opcao = Integer.parseInt(scanner.nextLine().trim());

                    switch (opcao) {
                        case 1 -> menuAdotantes(gestaoAdotantes, scanner);
                        case 2 -> menuAnimais(gestaoAnimais, scanner);
                        case 3 -> menuAdocoes(gestaoAdocoes, gestaoAdotantes, gestaoAnimais, scanner);
                        case 4 -> {
                            System.out.println("Encerrando sistema...");
                            return;
                        }
                        default -> System.out.println("⚠️ Opção inválida. Tente novamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Por favor, digite apenas números.");
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static void menuAdotantes(GestaoAdotantes gestao, Scanner scanner) {
        while (true) {
            System.out.println("\n--- GESTÃO DE ADOTANTES ---");
            System.out.println("[1] Adicionar Perfil Adotante");
            System.out.println("[2] Editar Perfil Adotante");
            System.out.println("[3] Desabilitar/Habilitar Adotante");
            System.out.println("[4] Listar Todos Adotantes");
            System.out.println("[5] Voltar");
            System.out.print("Escolha: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine().trim());

                switch (opcao) {
                    case 1 -> gestao.adicionarAdotante(scanner);
                    case 2 -> gestao.editarAdotante(scanner);
                    case 3 -> gestao.alterarStatusAdotante(scanner);
                    case 4 -> gestao.listarAdotantes();
                    case 5 -> { return; }
                    default -> System.out.println("⚠️ Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Por favor, digite apenas números.");
            }
        }
    }

    private static void menuAnimais(GestaoAnimais gestao, Scanner scanner) {
        while (true) {
            System.out.println("\n--- GESTÃO DE ANIMAIS ---");
            System.out.println("[1] Adicionar Cachorro");
            System.out.println("[2] Adicionar Gato");
            System.out.println("[3] Remover Animal");
            System.out.println("[4] Desabilitar/Habilitar Animal");
            System.out.println("[5] Listar Todos Animais");
            System.out.println("[6] Voltar");
            System.out.print("Escolha: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine().trim());

                switch (opcao) {
                    case 1 -> gestao.adicionarCao(scanner);
                    case 2 -> gestao.adicionarGato(scanner);
                    case 3 -> gestao.removerAnimal(scanner);
                    case 4 -> gestao.alterarStatusAnimal(scanner);
                    case 5 -> gestao.listarAnimais();
                    case 6 -> { return; }
                    default -> System.out.println("⚠️ Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Por favor, digite apenas números.");
            }
        }
    }

    private static void menuAdocoes(GestaoAdocoes gestao, GestaoAdotantes adotantes, GestaoAnimais animais, Scanner scanner) {
        while (true) {
            System.out.println("\n--- GESTÃO DE ADOÇÕES ---");
            System.out.println("[1] Gerar Adoção");
            System.out.println("[2] Realizar Adoção");
            System.out.println("[3] Listar Adoções");
            System.out.println("[4] Voltar");
            System.out.print("Escolha: ");

            try {
                int opcao = Integer.parseInt(scanner.nextLine().trim());

                switch (opcao) {
                    case 1 -> gestao.gerarAdocao(adotantes.getAdotantes(), animais.getAnimais(), scanner);
                    case 2 -> gestao.realizarAdocao(scanner);
                    case 3 -> gestao.listarAdocoes();
                    case 4 -> { return; }
                    default -> System.out.println("⚠️ Opção inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Por favor, digite apenas números.");
            }
        }
    }
}