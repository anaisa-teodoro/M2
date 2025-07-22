package service;

import model.Animal;
import model.Cao;
import model.Gato;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoAnimais {
    private List<Animal> animais = new ArrayList<>();

    public void adicionarCao(Scanner scanner) {
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine().trim();

            // Verificar se ID já existe
            if (existeId(id)) {
                System.out.println("⚠️ ID já existe. Tente outro.");
                return;
            }

            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Condição de Saúde: ");
            String saude = scanner.nextLine().trim();

            System.out.print("Temperamento: ");
            String temperamento = scanner.nextLine().trim();

            System.out.print("Porte (pequeno/médio/grande): ");
            String porte = scanner.nextLine().trim();

            System.out.print("Necessita passeio? (true/false): ");
            boolean passeio = Boolean.parseBoolean(scanner.nextLine().trim());

            Cao cao = new Cao(id, nome, idade, saude, temperamento, "disponível", porte, passeio);
            animais.add(cao);
            System.out.println("✅ Cachorro adicionado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Erro: Idade deve ser um número.");
        } catch (Exception e) {
            System.out.println("⚠️ Erro ao adicionar cachorro: " + e.getMessage());
        }
    }

    public void adicionarGato(Scanner scanner) {
        try {
            System.out.print("ID: ");
            String id = scanner.nextLine().trim();

            // Verificar se ID já existe
            if (existeId(id)) {
                System.out.println("⚠️ ID já existe. Tente outro.");
                return;
            }

            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Condição de Saúde: ");
            String saude = scanner.nextLine().trim();

            System.out.print("Temperamento: ");
            String temperamento = scanner.nextLine().trim();

            System.out.print("Convive com outros gatos? (true/false): ");
            boolean convive = Boolean.parseBoolean(scanner.nextLine().trim());

            Gato gato = new Gato(id, nome, idade, saude, temperamento, "disponível", convive);
            animais.add(gato);
            System.out.println("✅ Gato adicionado com sucesso!");
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Erro: Idade deve ser um número.");
        } catch (Exception e) {
            System.out.println("⚠️ Erro ao adicionar gato: " + e.getMessage());
        }
    }

    public void removerAnimal(Scanner scanner) {
        if (animais.isEmpty()) {
            System.out.println("⚠️ Nenhum animal cadastrado.");
            return;
        }

        System.out.print("ID do animal a remover: ");
        String id = scanner.nextLine().trim();

        Animal encontrado = null;
        for (Animal a : animais) {
            if (a.getId().equals(id)) {
                encontrado = a;
                break;
            }
        }

        if (encontrado != null) {
            animais.remove(encontrado);
            System.out.println("✅ Animal removido com sucesso.");
        } else {
            System.out.println("⚠️ Animal não encontrado.");
        }
    }

    public void alterarStatusAnimal(Scanner scanner) {
        if (animais.isEmpty()) {
            System.out.println("⚠️ Nenhum animal cadastrado.");
            return;
        }

        System.out.print("ID do animal: ");
        String id = scanner.nextLine().trim();

        for (Animal a : animais) {
            if (a.getId().equals(id)) {
                String novoStatus = a.getStatus().equalsIgnoreCase("disponível") ? "indisponível" : "disponível";
                a.setStatus(novoStatus);
                System.out.println("✅ Status alterado para: " + novoStatus);
                return;
            }
        }
        System.out.println("⚠️ Animal não encontrado.");
    }

    public void listarAnimais() {
        if (animais.isEmpty()) {
            System.out.println("⚠️ Nenhum animal cadastrado.");
        } else {
            System.out.println("\n--- LISTA DE ANIMAIS ---");
            for (Animal a : animais) {
                System.out.println(a.gerarRelatorio());
                System.out.println("─".repeat(50));
            }
        }
    }

    private boolean existeId(String id) {
        return animais.stream().anyMatch(a -> a.getId().equals(id));
    }

    public List<Animal> getAnimais() {
        return animais;
    }
}