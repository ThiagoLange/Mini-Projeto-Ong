package com.example.animais;

import com.example.animais.gestao.Adocao;
import com.example.animais.gestao.Adotante;
import com.example.animais.model.Animal;
import com.example.animais.model.Cao;
import com.example.animais.model.Gato;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // --- 1. Cadastro de Animais ---
        Cao cao1 = new Cao("c001", "Rex", 5, "Saudável", "Dócil", "Disponível para adoção", "Médio", true);
        Gato gato1 = new Gato("g001", "Misty", 2, "Saudável", "Calmo", "Disponível para adoção", true);

        List<Animal> listaDeAnimais = new ArrayList<>();
        listaDeAnimais.add(cao1);
        listaDeAnimais.add(gato1);

        System.out.println("--- Status Inicial dos Animais ---");
        listaDeAnimais.forEach(System.out::println);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // --- 2. Cadastro de Adotante ---
        Adotante adotante1 = new Adotante("Ana Silva", "123.456.789-00", "Rua das Flores, 123", "(47) 99999-8888", "Prefere cães dóceis e de porte médio");
        System.out.println("--- Adotante Cadastrado ---");
        System.out.println(adotante1);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // --- 3. Processo de Adoção ---
        // Simula a adoção do cão Rex pela Ana
        System.out.println("--- Registrando Processo de Adoção ---");
        Adocao processoAdocao1 = new Adocao(adotante1, cao1, new Date(), true);
        System.out.println("Registro de Adoção criado com sucesso!");
        System.out.println(processoAdocao1);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // --- 4. Verificação do Status Pós-Adoção ---
        System.out.println("--- Status Final dos Animais ---");
        // Note que o status do 'cao1' foi atualizado automaticamente pelo construtor de 'Adocao'
        listaDeAnimais.forEach(System.out::println);
    }
}