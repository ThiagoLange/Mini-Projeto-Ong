package com.example.animais;

import com.example.animais.gestao.Adocao;
import com.example.animais.gestao.Adotante;
import com.example.animais.model.Animal;
import com.example.animais.model.Cao;
import com.example.animais.model.Gato;
1
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal que gerencia a execução da aplicação,
 * apresentando um menu interativo para o usuário.
 */
public class Main {

    // Scanner para ler a entrada do usuário em toda a aplicação
    private static final Scanner scanner = new Scanner(System.in);

    // Listas para armazenar os dados em memória (simulando um banco de dados)
    private static final List<Adotante> adotantes = new ArrayList<>();
    private static final List<Animal> animais = new ArrayList<>();
    private static final List<Adocao> adocoes = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializa a aplicação com alguns dados para teste
        carregarDadosIniciais();

        boolean executando = true;
        while (executando) {
            exibirMenuPrincipal();
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha deixada pelo nextInt()

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
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.nextLine(); // Limpa o buffer do scanner para evitar um loop infinito
            }
            pressioneEnterParaContinuar();
        }
        scanner.close();
    }

    /**
     * Exibe o menu principal da aplicação.
     */
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

    /**
     * Placeholder para o menu de gestão de adotantes.
     */
    private static void menuGestaoAdotantes() {
        System.out.println("\n--- Módulo de Gestão de Adotantes ---");
        // Futuramente, aqui entrarão as opções: Cadastrar, Listar, Atualizar, Excluir Adotante
        System.out.println("Total de adotantes cadastrados: " + adotantes.size());
        adotantes.forEach(System.out::println);
    }

    /**
     * Placeholder para o menu de gestão de animais.
     */
    private static void menuGestaoAnimais() {
        System.out.println("\n--- Módulo de Gestão de Animais ---");
        // Futuramente, aqui entrarão as opções: Cadastrar, Listar, Atualizar, Excluir Animal
        System.out.println("Total de animais no abrigo: " + animais.size());
        animais.forEach(System.out::println);
    }

    /**
     * Placeholder para o menu de gestão de adoções.
     */
    private static void menuGestaoAdocoes() {
        System.out.println("\n--- Módulo de Gestão de Adoções ---");
        // Futuramente, aqui entrarão as opções: Registrar Nova Adoção, Listar Adoções
        System.out.println("Total de adoções realizadas: " + adocoes.size());
        adocoes.forEach(System.out::println);
    }

    /**
     * Pausa a execução e aguarda o usuário pressionar Enter.
     */
    private static void pressioneEnterParaContinuar() {
        System.out.println("\nPressione Enter para voltar ao menu...");
        scanner.nextLine();
    }

    /**
     * Carrega dados iniciais nas listas para facilitar testes e demonstrações.
     */
    private static void carregarDadosIniciais() {
        // Adotantes
        adotantes.add(new Adotante("Ana Silva", "123.456.789-00", "Rua das Flores, 123, Joinville", "(47) 99999-8888", "Prefere cães dóceis"));
        adotantes.add(new Adotante("João Santos", "987.654.321-00", "Avenida Brasil, 456, Joinville", "(47) 98888-7777", "Busca um gato independente"));

        // Animais
        animais.add(new Cao("c001", "Rex", 5, "Saudável", "Dócil", "Disponível para adoção", "Médio", true));
        animais.add(new Gato("g001", "Misty", 2, "Saudável", "Calmo", "Disponível para adoção", true));
        animais.add(new Cao("c002", "Bolinha", 1, "Saudável", "Brincalhão", "Disponível para adoção", "Pequeno", true));

        System.out.println("Dados iniciais carregados.");
    }
}