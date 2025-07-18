package com.example.animais;

import com.example.animais.gestao.Adocao;
import com.example.animais.gestao.Adotante;
import com.example.animais.model.Animal;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Classe principal que gerencia a execução da aplicação,
 * apresentando um menu interativo para o usuário.
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Adotante> adotantes = new ArrayList<>();
    private static final List<Animal> animais = new ArrayList<>();
    private static final List<Adocao> adocoes = new ArrayList<>();

    public static void main(String[] args) {
        carregarDadosIniciais();
        boolean executando = true;
        while (executando) {
            exibirMenuPrincipal();
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        menuGestaoAdotantes();
                        break;
                    case 2:
                        menuGestaoAnimais();
                        break;
                    case 3:
                        menuGestaoAdocoes();
                        break;
                    case 4:
                        executando = false;
                        System.out.println("Encerrando o sistema. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                        pressioneEnterParaContinuar();
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
                pressioneEnterParaContinuar();
            }
        }
        scanner.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== SISTEMA DE GESTÃO DE ADOÇÕES =====");
        System.out.println("Data e Hora: " + java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(java.time.LocalDateTime.now()));
        System.out.println("Localização: Joinville, SC");
        System.out.println("========================================");
        System.out.println("[1] Gestão de Adotantes");
        System.out.println("[2] Gestão de Animais");
        System.out.println("[3] Gestão de Adoções");
        System.out.println("[4] Sair");
        System.out.print("Escolha uma opção: ");
    }

    // --- MÓDULO DE GESTÃO DE ADOTANTES ---
    private static void menuGestaoAdotantes() {
        boolean voltando = false;
        while (!voltando) {
            System.out.println("\n--- Módulo de Gestão de Adotantes ---");
            System.out.println("[1] Adicionar Perfil Adotante");
            System.out.println("[2] Editar Perfil Adotante");
            System.out.println("[3] Desabilitar/Habilitar Adotante");
            System.out.println("[4] Listar Todos os Adotantes");
            System.out.println("[5] Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1: adicionarAdotante(); break;
                    case 2: editarAdotante(); break;
                    case 3: alterarStatusAdotante(); break;
                    case 4: listarTodosAdotantes(); break;
                    case 5: voltando = true; break;
                    default: System.out.println("Opção inválida."); break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida.");
                scanner.nextLine();
            }
            if (!voltando) pressioneEnterParaContinuar();
        }
    }
    private static void adicionarAdotante() {
        System.out.println("\n--- Adicionar Novo Adotante ---");
        System.out.print("Nome completo: "); String nome = scanner.nextLine();
        System.out.print("CPF (xxx.xxx.xxx-xx): "); String cpf = scanner.nextLine();
        System.out.print("Endereço: "); String endereco = scanner.nextLine();
        System.out.print("Telefone: "); String telefone = scanner.nextLine();
        System.out.print("Preferências: "); String preferencias = scanner.nextLine();
        adotantes.add(new Adotante(nome, cpf, endereco, telefone, preferencias));
        System.out.println("Adotante adicionado com sucesso!");
    }
    private static void editarAdotante() {
        System.out.println("\n--- Editar Perfil de Adotante ---");
        Adotante adotante = buscarAdotantePorCPF();
        if (adotante == null) { System.out.println("Adotante não encontrado."); return; }
        System.out.println("O que você deseja editar? [1] Endereço [2] Telefone [3] Preferências");
        int opcao = scanner.nextInt(); scanner.nextLine();
        switch (opcao) {
            case 1: System.out.print("Novo endereço: "); adotante.setEndereco(scanner.nextLine()); break;
            case 2: System.out.print("Novo telefone: "); adotante.setTelefone(scanner.nextLine()); break;
            case 3: System.out.print("Novas preferências: "); adotante.setPreferencias(scanner.nextLine()); break;
            default: System.out.println("Opção inválida."); return;
        }
        System.out.println("Perfil atualizado com sucesso!");
    }
    private static void alterarStatusAdotante() {
        System.out.println("\n--- Desabilitar/Habilitar Adotante ---");
        Adotante adotante = buscarAdotantePorCPF();
        if (adotante == null) { System.out.println("Adotante não encontrado."); return; }
        adotante.setAptoParaAdocao(!adotante.isAptoParaAdocao());
        System.out.println("Status alterado para: " + (adotante.isAptoParaAdocao() ? "Apto" : "Inapto"));
    }
    private static void listarTodosAdotantes() {
        System.out.println("\n--- Relatório de Todos os Adotantes ---");
        if (adotantes.isEmpty()) { System.out.println("Nenhum adotante cadastrado."); return; }
        adotantes.forEach(adotante -> System.out.println(adotante.gerarRelatorio()));
    }
    private static Adotante buscarAdotantePorCPF() {
        listarAdotantesSimples();
        if (adotantes.isEmpty()) return null;
        System.out.print("Digite o CPF do adotante: ");
        String cpf = scanner.nextLine();
        return adotantes.stream().filter(a -> a.getCpf().equals(cpf)).findFirst().orElse(null);
    }
    private static void listarAdotantesSimples() {
        if (adotantes.isEmpty()) { System.out.println("Nenhum adotante cadastrado."); return; }
        System.out.println("Adotantes cadastrados:");
        adotantes.forEach(ad -> System.out.println(" - Nome: " + ad.getNome() + ", CPF: " + ad.getCpf() + ", Status: " + (ad.isAptoParaAdocao() ? "Apto" : "Inapto")));
    }

    // --- MÓDULO DE GESTÃO DE ANIMAIS ---
    private static void menuGestaoAnimais() {
        boolean voltando = false;
        while (!voltando) {
            System.out.println("\n--- Módulo de Gestão de Animais ---");
            System.out.println("[1] Adicionar Cachorro");
            System.out.println("[2] Adicionar Gato");
            System.out.println("[3] Remover Animal");
            System.out.println("[4] Desabilitar/Habilitar Animal");
            System.out.println("[5] Listar Todos os Animais");
            System.out.println("[6] Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1: adicionarCachorro(); break;
                    case 2: adicionarGato(); break;
                    case 3: removerAnimal(); break;
                    case 4: alterarStatusAnimal(); break;
                    case 5: listarTodosAnimais(); break;
                    case 6: voltando = true; break;
                    default: System.out.println("Opção inválida."); break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida.");
                scanner.nextLine();
            }
            if (!voltando) pressioneEnterParaContinuar();
        }
    }
    private static void adicionarCachorro() { /* ... código anterior sem alteração ... */ }
    private static void adicionarGato() { /* ... código anterior sem alteração ... */ }
    private static void removerAnimal() {
        System.out.println("\n--- Remover Animal ---");
        Animal animal = buscarAnimalPorId();
        if (animal == null) { System.out.println("Animal não encontrado."); return; }
        animais.remove(animal);
        System.out.println("Animal removido com sucesso!");
    }
    private static void alterarStatusAnimal() {
        System.out.println("\n--- Desabilitar/Habilitar Animal ---");
        Animal animal = buscarAnimalPorId();
        if (animal == null) { System.out.println("Animal não encontrado."); return; }
        if (animal.getStatus().equalsIgnoreCase("Adotado")) {
            System.out.println("Não é possível alterar o status de um animal já adotado.");
            return;
        }
        String novoStatus = animal.getStatus().equalsIgnoreCase("Disponível para adoção") ? "Inapto para adoção" : "Disponível para adoção";
        animal.setStatus(novoStatus);
        System.out.println("Status alterado para: " + novoStatus);
    }
    private static void listarTodosAnimais() {
        System.out.println("\n--- Relatório de Todos os Animais ---");
        if (animais.isEmpty()) { System.out.println("Nenhum animal cadastrado."); return; }
        animais.forEach(animal -> System.out.println(animal.gerarRelatorio()));
    }
    private static Animal buscarAnimalPorId() {
        listarAnimaisSimples();
        if (animais.isEmpty()) return null;
        System.out.print("Digite o ID do animal: ");
        String id = scanner.nextLine();
        return animais.stream().filter(a -> a.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
    private static void listarAnimaisSimples() {
        if (animais.isEmpty()) { System.out.println("Nenhum animal cadastrado."); return; }
        System.out.println("Animais cadastrados:");
        animais.forEach(a -> System.out.println(" - Espécie: " + a.getEspecie() + ", ID: " + a.getId() + ", Nome: " + a.getNome() + ", Status: " + a.getStatus()));
    }

    // --- MÓDULO DE GESTÃO DE ADOÇÕES (NOVA IMPLEMENTAÇÃO) ---

    private static void menuGestaoAdocoes() {
        boolean voltando = false;
        while (!voltando) {
            System.out.println("\n--- Módulo de Gestão de Adoções ---");
            System.out.println("[1] Gerar Adoção (Registrar Interesse)");
            System.out.println("[2] Realizar Adoção (Finalizar Processo)");
            System.out.println("[3] Listar Todas as Adoções");
            System.out.println("[4] Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1: gerarAdocao(); break;
                    case 2: realizarAdocao(); break;
                    case 3: listarAdocoes(); break;
                    case 4: voltando = true; break;
                    default: System.out.println("Opção inválida."); break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida.");
                scanner.nextLine();
            }
            if (!voltando) pressioneEnterParaContinuar();
        }
    }

    private static void gerarAdocao() {
        System.out.println("\n--- Gerar Nova Adoção ---");

        System.out.println("\nAdotantes Aptos:");
        List<Adotante> aptos = adotantes.stream().filter(Adotante::validar).collect(Collectors.toList());
        if(aptos.isEmpty()) { System.out.println("Nenhum adotante apto encontrado."); return; }
        aptos.forEach(ad -> System.out.println(" - Nome: " + ad.getNome() + ", CPF: " + ad.getCpf()));
        System.out.print("Digite o CPF do adotante: ");
        String cpf = scanner.nextLine();
        Adotante adotante = aptos.stream().filter(a -> a.getCpf().equals(cpf)).findFirst().orElse(null);

        if (adotante == null) { System.out.println("Adotante inválido ou não encontrado na lista de aptos."); return; }

        System.out.println("\nAnimais Disponíveis para Adoção:");
        List<Animal> disponiveis = animais.stream().filter(Animal::validar).collect(Collectors.toList());
        if(disponiveis.isEmpty()) { System.out.println("Nenhum animal disponível para adoção."); return; }
        disponiveis.forEach(an -> System.out.println(" - Espécie: " + an.getEspecie() + ", ID: " + an.getId() + ", Nome: " + an.getNome()));
        System.out.print("Digite o ID do animal: ");
        String idAnimal = scanner.nextLine();
        Animal animal = disponiveis.stream().filter(a -> a.getId().equalsIgnoreCase(idAnimal)).findFirst().orElse(null);

        if (animal == null) { System.out.println("Animal inválido ou não encontrado na lista de disponíveis."); return; }

        Adocao novaAdocao = new Adocao(adotante, animal);
        adocoes.add(novaAdocao);

        // Importante: Mudar o status do animal para "Em processo de adoção"
        animal.setStatus("Em processo de adoção");

        System.out.println("\nRegistro de interesse de adoção gerado com sucesso!");
        System.out.println("ID da Adoção: " + novaAdocao.getId());
    }

    private static void realizarAdocao() {
        System.out.println("\n--- Realizar Adoção (Finalizar) ---");
        List<Adocao> pendentes = adocoes.stream().filter(a -> !a.isTermoAssinado()).collect(Collectors.toList());
        if (pendentes.isEmpty()) {
            System.out.println("Nenhuma adoção pendente para ser realizada.");
            return;
        }

        System.out.println("Adoções pendentes:");
        pendentes.forEach(a -> System.out.println(" - ID: " + a.getId() + ", Adotante: " + a.getAdotante().getNome() + ", Animal: " + a.getAnimalAdotado().getNome()));

        System.out.print("Digite o ID da adoção que deseja realizar: ");
        String idAdocao = scanner.nextLine();

        Adocao adocaoParaRealizar = pendentes.stream().filter(a -> a.getId().equals(idAdocao)).findFirst().orElse(null);

        if (adocaoParaRealizar == null) {
            System.out.println("Adoção não encontrada ou já realizada.");
            return;
        }

        adocaoParaRealizar.realizarAdoção();
        System.out.println("Adoção realizada com sucesso! O animal '" + adocaoParaRealizar.getAnimalAdotado().getNome() + "' foi oficialmente adotado.");
    }

    private static void listarAdocoes() {
        System.out.println("\n--- Relatório de Todas as Adoções ---");
        if (adocoes.isEmpty()) {
            System.out.println("Nenhum registro de adoção encontrado.");
            return;
        }
        adocoes.forEach(System.out::println);
    }

    // --- MÉTODOS UTILITÁRIOS ---

    private static void pressioneEnterParaContinuar() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void carregarDadosIniciais() {
        // ... código anterior sem alteração ...
    }
}