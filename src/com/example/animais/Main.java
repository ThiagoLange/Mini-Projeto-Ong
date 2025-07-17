package com.example.animais;

import com.example.animais.gestao.Adocao;
import com.example.animais.gestao.Adotante;
import com.example.animais.model.Animal;
import com.example.animais.model.Cao;
import com.example.animais.model.Gato;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
                    case 1:
                        adicionarAdotante();
                        break;
                    case 2:
                        editarAdotante();
                        break;
                    case 3:
                        alterarStatusAdotante();
                        break;
                    case 4:
                        listarTodosAdotantes();
                        break;
                    case 5:
                        voltando = true;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.nextLine();
            }
            if (!voltando) pressioneEnterParaContinuar();
        }
    }

    private static void adicionarAdotante() {
        System.out.println("\n--- Adicionar Novo Adotante ---");
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();
        System.out.print("CPF (xxx.xxx.xxx-xx): ");
        String cpf = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Preferências (ex: 'cães dóceis', 'gatos independentes'): ");
        String preferencias = scanner.nextLine();

        adotantes.add(new Adotante(nome, cpf, endereco, telefone, preferencias));
        System.out.println("Adotante adicionado com sucesso!");
    }

    private static void editarAdotante() {
        System.out.println("\n--- Editar Perfil de Adotante ---");
        listarAdotantesSimples();
        if (adotantes.isEmpty()) return;

        System.out.print("Digite o CPF do adotante que deseja editar: ");
        String cpf = scanner.nextLine();

        Adotante adotanteParaEditar = null;
        for (Adotante ad : adotantes) {
            if (ad.getCpf().equals(cpf)) {
                adotanteParaEditar = ad;
                break;
            }
        }

        if (adotanteParaEditar == null) {
            System.out.println("Adotante não encontrado.");
            return;
        }

        System.out.println("O que você deseja editar?");
        System.out.println("[1] Endereço");
        System.out.println("[2] Telefone");
        System.out.println("[3] Preferências");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                System.out.print("Novo endereço: ");
                adotanteParaEditar.setEndereco(scanner.nextLine());
                break;
            case 2:
                System.out.print("Novo telefone: ");
                adotanteParaEditar.setTelefone(scanner.nextLine());
                break;
            case 3:
                System.out.print("Novas preferências: ");
                adotanteParaEditar.setPreferencias(scanner.nextLine());
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }
        System.out.println("Perfil do adotante atualizado com sucesso!");
    }

    private static void alterarStatusAdotante() {
        System.out.println("\n--- Desabilitar/Habilitar Adotante ---");
        listarAdotantesSimples();
        if (adotantes.isEmpty()) return;

        System.out.print("Digite o CPF do adotante para alterar o status: ");
        String cpf = scanner.nextLine();

        Adotante adotanteParaAlterar = null;
        for (Adotante ad : adotantes) {
            if (ad.getCpf().equals(cpf)) {
                adotanteParaAlterar = ad;
                break;
            }
        }

        if (adotanteParaAlterar == null) {
            System.out.println("Adotante não encontrado.");
            return;
        }

        // Inverte o status atual
        adotanteParaAlterar.setAptoParaAdocao(!adotanteParaAlterar.isAptoParaAdocao());

        System.out.println("Status do adotante " + adotanteParaAlterar.getNome() +
                " alterado para: " + (adotanteParaAlterar.isAptoParaAdocao() ? "Apto" : "Inapto"));
    }

    private static void listarTodosAdotantes() {
        System.out.println("\n--- Relatório de Todos os Adotantes ---");
        if (adotantes.isEmpty()) {
            System.out.println("Nenhum adotante cadastrado.");
            return;
        }
        adotantes.forEach(adotante -> System.out.println(adotante.gerarRelatorio()));
    }

    private static void listarAdotantesSimples() {
        if (adotantes.isEmpty()) {
            System.out.println("Nenhum adotante cadastrado.");
            return;
        }
        System.out.println("Adotantes cadastrados:");
        for (Adotante ad : adotantes) {
            System.out.println(" - Nome: " + ad.getNome() + ", CPF: " + ad.getCpf() + ", Status: " + (ad.isAptoParaAdocao() ? "Apto" : "Inapto"));
        }
    }


    // --- OUTROS MÓDULOS (PLACEHOLDERS) ---

    private static void menuGestaoAnimais() {
        System.out.println("\n--- Módulo de Gestão de Animais (Em desenvolvimento) ---");
        System.out.println("Total de animais no abrigo: " + animais.size());
        animais.forEach(System.out::println);
    }

    private static void menuGestaoAdocoes() {
        System.out.println("\n--- Módulo de Gestão de Adoções (Em desenvolvimento) ---");
        System.out.println("Total de adoções realizadas: " + adocoes.size());
        adocoes.forEach(System.out::println);
    }

    private static void pressioneEnterParaContinuar() {
        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine();
    }

    private static void carregarDadosIniciais() {
        adotantes.add(new Adotante("Ana Silva", "123.456.789-00", "Rua das Flores, 123, Joinville", "(47) 99999-8888", "Prefere cães dóceis"));
        adotantes.add(new Adotante("João Santos", "987.654.321-00", "Avenida Brasil, 456, Joinville", "(47) 98888-7777", "Busca um gato independente"));

        animais.add(new Cao("c001", "Rex", 5, "Saudável", "Dócil", "Disponível para adoção", "Médio", true));
        animais.add(new Gato("g001", "Misty", 2, "Saudável", "Calmo", "Disponível para adoção", true));
        animais.add(new Cao("c002", "Bolinha", 1, "Saudável", "Brincalhão", "Disponível para adoção", "Pequeno", true));

        System.out.println("Dados iniciais carregados.");
    }
}