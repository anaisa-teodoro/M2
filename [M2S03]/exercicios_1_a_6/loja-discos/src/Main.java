import java.util.*;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static List<Genero> generos = new ArrayList<>();
    static List<Disco> discos = new ArrayList<>();
    static List<Autor> autores = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n[1] Generos\n[2] Discos\n[3] Autores\n[4] Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                menuGenero();
            } else if (opcao == 2) {
                menuDisco();
            } else if (opcao == 3) {
                menuAutor();
            }
        }
    }

    static void menuGenero() {
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n[1] Novo Genero\n[2] Excluir Genero\n[3] Listar Generos\n[4] Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Descrição: ");
                String descricao = scanner.nextLine();
                generos.add(new Genero(nome, descricao));
            } else if (opcao == 2) {
                System.out.print("Nome do gênero a excluir: ");
                String nome = scanner.nextLine();
                for (int i = 0; i < generos.size(); i++) {
                    if (generos.get(i).getNome().equalsIgnoreCase(nome)) {
                        generos.remove(i);
                        break;
                    }
                }
            } else if (opcao == 3) {
                for (int i = 0; i < generos.size(); i++) {
                    System.out.println(generos.get(i).getInfo());
                }
            }
        }
    }

    static void menuDisco() {
        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n[1] Novo Disco\n[2] Inativar Disco\n[3] Listar Discos\n[4] Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Título do disco: ");
                String titulo = scanner.nextLine();

                System.out.println("Escolha o gênero:");
                for (int i = 0; i < generos.size(); i++) {
                    System.out.println("[" + i + "] " + generos.get(i).getNome());
                }

                int index = scanner.nextInt();
                scanner.nextLine();

                if (index >= 0 && index < generos.size()) {
                    discos.add(new Disco(titulo, generos.get(index)));
                }
            } else if (opcao == 2) {
                System.out.print("Título do disco a inativar: ");
                String titulo = scanner.nextLine();

                for (int i = 0; i < discos.size(); i++) {
                    if (discos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                        discos.get(i).inativar();
                        break;
                    }
                }
            } else if (opcao == 3) {
                for (int i = 0; i < discos.size(); i++) {
                    System.out.println(discos.get(i).getInfo());
                }
            }
        }
    }

    static void menuAutor() {
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n[1] Novo Autor\n[2] Listar Autores\n[3] Sair");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do autor: ");
                String nome = scanner.nextLine();

                System.out.println("Escolha o disco:");
                for (int i = 0; i < discos.size(); i++) {
                    System.out.println("[" + i + "] " + discos.get(i).getTitulo());
                }

                int index = scanner.nextInt();
                scanner.nextLine();

                if (index >= 0 && index < discos.size()) {
                    autores.add(new Autor(nome, discos.get(index)));
                }
            } else if (opcao == 2) {
                for (int i = 0; i < autores.size(); i++) {
                    System.out.println(autores.get(i).getInfo());
                }
            }
        }
    }
}


/*
 * Justificativa das Escolhas de Classe, conforme solicitacao do exercicio MS0203:
 *
 * Classe Genero:
 * - Criada com os atributos 'nome' e 'descricao', pois são essenciais para identificar e descrever um gênero musical.
 * - O metodo getInfo() foi implementado para facilitar a exibição formatada das informações do gênero.
 *
 * Classe Disco:
 * - Contém os atributos 'titulo', 'genero' (relacionamento com a classe Genero) e 'ativo' (booleano para controle de disponibilidade).
 * - O metodo getInfo() retorna os dados do disco, incluindo as informações do gênero, acessadas via o metodo da classe Genero.
 *
 * Classe Autor:
 * - Possui os atributos 'nome' e 'disco' (relacionamento com a classe Disco), pois cada autor está vinculado a um disco.
 * - O metodo getInfo() retorna as informações completas do autor e do disco associado.
 *
 * Menus:
 * - Foram criados menus interativos no metodo main para simular um sistema simples de gerenciamento.
 * - As opções permitem operações básicas de criar, listar, excluir/inativar, facilitando a manipulação dos dados em tempo de execução.
 */
