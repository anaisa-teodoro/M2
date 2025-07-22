
import model.Biblioteca;
import model.Livro;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Gestão de Livros");
            System.out.println("2. Gestão de Empréstimos");
            System.out.println("3. Relatórios e Consultas");
            System.out.println("4. Administração do Sistema");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1 -> menuGestaoLivros();
                case 2 -> menuGestaoEmprestimos();
                case 3 -> menuRelatorios();
                case 4 -> menuAdministracao();
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuGestaoLivros() {
        int opcao;
        do {
            System.out.println("\n--- Gestão de Livros ---");
            System.out.println("1. Cadastrar Novo Livro");
            System.out.println("2. Editar Informações de Livro");
            System.out.println("3. Remover Livro do Acervo");
            System.out.println("4. Listar Todos os Livros");
            System.out.println("5. Buscar Livro por ISBN");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarLivro();
                case 2 -> editarLivro();
                case 3 -> removerLivro();
                case 4 -> listarTodosLivros();
                case 5 -> buscarPorIsbn();
                case 0 -> {}
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuGestaoEmprestimos() {
        int opcao;
        do {
            System.out.println("\n--- Gestão de Empréstimos ---");
            System.out.println("1. Registrar Empréstimo");
            System.out.println("2. Registrar Devolução");
            System.out.println("3. Listar Livros Emprestados");
            System.out.println("4. Listar Livros Disponíveis");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> registrarEmprestimo();
                case 2 -> registrarDevolucao();
                case 3 -> listarEmprestados();
                case 4 -> listarDisponiveis();
                case 0 -> {}
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuRelatorios() {
        int opcao;
        do {
            System.out.println("\n--- Relatórios e Consultas ---");
            System.out.println("1. Relatório Completo do Acervo");
            System.out.println("2. Buscar Livros por Autores");
            System.out.println("3. Estatísticas de Empréstimos");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> biblioteca.exibirRelatorio();
                case 2 -> buscarPorAutor();
                case 3 -> estatisticasEmprestimos();
                case 0 -> {}
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void menuAdministracao() {
        int opcao;
        do {
            System.out.println("\n--- Administração do Sistema ---");
            System.out.println("1. Total de Livros Cadastrados");
            System.out.println("2. Total de Bibliotecas");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> System.out.println("Total de livros cadastrados: " + Livro.getTotalLivros());
                case 2 -> System.out.println("Total de bibliotecas: " + biblioteca.getTotalBibliotecas());
                case 0 -> {}
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    // Métodos auxiliares
    private static void cadastrarLivro() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();

        Livro livro = new Livro(isbn, titulo, autor);
        biblioteca.adicionarLivro(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }


    private static void editarLivro() {
        System.out.print("ISBN do livro a editar: ");
        String isbn = scanner.nextLine();
        for (Livro livro : biblioteca.buscaPorAutor()) {
            if (livro.getIsbn().equals(isbn)) {
                System.out.print("Novo título: ");
                String novoTitulo = scanner.nextLine();
                System.out.print("Novo autor: ");
                String novoAutor = scanner.nextLine();

                livro.setTitulo(novoTitulo);
                livro.setAutor(novoAutor);

                System.out.println("Livro editado com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }


    private static void removerLivro() {
        System.out.print("ISBN do livro a remover: ");
        String isbn = scanner.nextLine();
        boolean removido = biblioteca.devolverLivro(isbn); // Simulação
        System.out.println(removido ? "Livro removido." : "Livro não encontrado ou emprestado.");
    }

    private static void listarTodosLivros() {
        biblioteca.exibirRelatorio();
    }

    private static void buscarPorIsbn() {
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        for (Livro livro : biblioteca.buscaPorAutor()) {
            if (livro.getIsbn().equals(isbn)) {
                System.out.println(livro.gerarDescricao());
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    private static void registrarEmprestimo() {
        System.out.print("ISBN do livro: ");
        String isbn = scanner.nextLine();
        boolean sucesso = biblioteca.emprestarLivro(isbn);
        System.out.println(sucesso ? "Empréstimo registrado." : "Livro não disponível.");
    }

    private static void registrarDevolucao() {
        System.out.print("ISBN do livro: ");
        String isbn = scanner.nextLine();
        boolean sucesso = biblioteca.devolverLivro(isbn);
        System.out.println(sucesso ? "Devolução registrada." : "Livro não está emprestado.");
    }

    private static void listarEmprestados() {
        System.out.println("Livros emprestados:");
        for (Livro livro : biblioteca.buscaPorAutor()) {
            if (livro.isEmprestado()) {
                System.out.println("- " + livro.getTitulo());
            }
        }
    }

    private static void listarDisponiveis() {
        System.out.println("Livros disponíveis:");
        for (Livro livro : biblioteca.buscaPorAutor()) {
            if (!livro.isEmprestado()) {
                System.out.println("- " + livro.getTitulo());
            }
        }
    }

    private static void buscarPorAutor() {
        System.out.print("Digite os autores (separados por vírgula): ");
        String[] autores = scanner.nextLine().split(",");
        for (Livro livro : biblioteca.buscaPorAutor(autores)) {
            System.out.println(livro.gerarDescricao());
        }
    }

    private static void estatisticasEmprestimos() {
        int emprestados = 0;
        int disponiveis = 0;
        for (Livro livro : biblioteca.buscaPorAutor()) {
            if (livro.isEmprestado()) emprestados++;
            else disponiveis++;
        }
        System.out.println("Livros emprestados: " + emprestados);
        System.out.println("Livros disponíveis: " + disponiveis);
    }
}
