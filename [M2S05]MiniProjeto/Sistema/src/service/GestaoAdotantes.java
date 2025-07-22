package service;

import model.Adotante;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoAdotantes {
    private List<Adotante> adotantes = new ArrayList<>();

    public void adicionarAdotante(Scanner scanner) {
        try {
            System.out.print("Nome: ");
            String nome = scanner.nextLine().trim();

            System.out.print("CPF: ");
            String cpf = scanner.nextLine().trim();

            // Verificar se CPF já existe
            if (existeCpf(cpf)) {
                System.out.println("⚠️ CPF já cadastrado.");
                return;
            }

            System.out.print("Endereço: ");
            String endereco = scanner.nextLine().trim();

            System.out.print("Preferências: ");
            String preferencias = scanner.nextLine().trim();

            Adotante adotante = new Adotante(nome, cpf, endereco, preferencias);
            adotantes.add(adotante);
            System.out.println("✅ Adotante adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("⚠️ Erro ao adicionar adotante: " + e.getMessage());
        }
    }

    public void editarAdotante(Scanner scanner) {
        if (adotantes.isEmpty()) {
            System.out.println("⚠️ Nenhum adotante cadastrado.");
            return;
        }

        System.out.print("CPF do adotante: ");
        String cpf = scanner.nextLine().trim();

        for (Adotante a : adotantes) {
            if (a.getCpf().equals(cpf)) {
                System.out.print("Novo endereço: ");
                String novoEndereco = scanner.nextLine().trim();
                a.setEndereco(novoEndereco);

                System.out.print("Novas preferências: ");
                String novasPreferencias = scanner.nextLine().trim();
                a.setPreferencias(novasPreferencias);

                System.out.println("✅ Dados atualizados.");
                return;
            }
        }
        System.out.println("⚠️ Adotante não encontrado.");
    }

    public void alterarStatusAdotante(Scanner scanner) {
        if (adotantes.isEmpty()) {
            System.out.println("⚠️ Nenhum adotante cadastrado.");
            return;
        }

        System.out.print("CPF do adotante: ");
        String cpf = scanner.nextLine().trim();

        for (Adotante a : adotantes) {
            if (a.getCpf().equals(cpf)) {
                a.setHabilitado(!a.isHabilitado());
                String status = a.isHabilitado() ? "habilitado" : "desabilitado";
                System.out.println("✅ Adotante " + status + ".");
                return;
            }
        }
        System.out.println("⚠️ Adotante não encontrado.");
    }

    public void listarAdotantes() {
        if (adotantes.isEmpty()) {
            System.out.println("⚠️ Nenhum adotante cadastrado.");
        } else {
            System.out.println("\n--- LISTA DE ADOTANTES ---");
            adotantes.forEach(a -> {
                System.out.println(a.gerarRelatorio());
                System.out.println("─".repeat(50));
            });
        }
    }

    private boolean existeCpf(String cpf) {
        return adotantes.stream().anyMatch(a -> a.getCpf().equals(cpf));
    }

    public List<Adotante> getAdotantes() {
        return adotantes;
    }
}