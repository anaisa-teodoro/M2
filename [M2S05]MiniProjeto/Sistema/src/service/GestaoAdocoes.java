package service;

import model.Adocao;
import model.Adotante;
import model.Animal;
import exceptions.ValidacaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestaoAdocoes {
    private List<Adocao> adocoes = new ArrayList<>();

    public void gerarAdocao(List<Adotante> adotantes, List<Animal> animais, Scanner scanner) {
        if (adotantes.isEmpty()) {
            System.out.println("⚠️ Nenhum adotante cadastrado.");
            return;
        }

        if (animais.isEmpty()) {
            System.out.println("⚠️ Nenhum animal cadastrado.");
            return;
        }

        System.out.print("CPF do adotante: ");
        String cpf = scanner.nextLine().trim();

        System.out.print("ID do animal: ");
        String id = scanner.nextLine().trim();

        Adotante adotante = adotantes.stream().filter(a -> a.getCpf().equals(cpf)).findFirst().orElse(null);
        Animal animal = animais.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);

        try {
            if (adotante == null) throw new ValidacaoException("Adotante não encontrado.");
            if (animal == null) throw new ValidacaoException("Animal não encontrado.");
            if (!adotante.validar()) throw new ValidacaoException("Adotante não habilitado.");
            if (!animal.validar()) throw new ValidacaoException("Animal não disponível para adoção.");

            // Verificar se já existe adoção pendente
            boolean existeAdocaoPendente = adocoes.stream()
                    .anyMatch(a -> a.getAdotante().getCpf().equals(cpf) &&
                            a.getAnimalAdotado().getId().equals(id) &&
                            !a.isTermoAssinado());

            if (existeAdocaoPendente) {
                throw new ValidacaoException("Já existe uma adoção pendente para este adotante e animal.");
            }

            adocoes.add(new Adocao(adotante, animal));
            System.out.println("✅ Adoção gerada com sucesso.");
        } catch (ValidacaoException e) {
            System.out.println("⚠️ Erro: " + e.getMessage());
        }
    }

    public void realizarAdocao(Scanner scanner) {
        if (adocoes.isEmpty()) {
            System.out.println("⚠️ Nenhuma adoção gerada.");
            return;
        }

        System.out.print("CPF do adotante: ");
        String cpf = scanner.nextLine().trim();

        for (Adocao a : adocoes) {
            if (a.getAdotante().getCpf().equals(cpf) && !a.isTermoAssinado()) {
                a.assinarTermo();
                a.getAnimalAdotado().setStatus("adotado");
                System.out.println("✅ Adoção realizada com sucesso!");
                return;
            }
        }
        System.out.println("⚠️ Adoção não encontrada ou já realizada.");
    }

    public void listarAdocoes() {
        if (adocoes.isEmpty()) {
            System.out.println("⚠️ Nenhuma adoção registrada.");
        } else {
            System.out.println("\n--- LISTA DE ADOÇÕES ---");
            adocoes.forEach(a -> {
                System.out.println(a.gerarRelatorio());
                System.out.println("─".repeat(50));
            });
        }
    }
}