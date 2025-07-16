package com.example.animais;

import com.example.animais.gestao.Adocao;
import com.example.animais.gestao.Adotante;
import com.example.animais.model.Animal;
import com.example.animais.model.Cao;
import com.example.animais.model.Gato;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // --- Cadastro de Entidades ---
        Cao cao = new Cao("c001", "Rex", 5, "Saudável", "Dócil", "Disponível para adoção", "Médio", true);
        Gato gato = new Gato("g001", "Misty", 2, "Saudável", "Calmo", "Disponível para adoção", true);
        Adotante adotante = new Adotante("Ana Silva", "123.456.789-00", "Rua das Flores, 123", "(47) 99999-8888", "Prefere cães dóceis");

        System.out.println("=".repeat(50));
        System.out.println("--- 1. VALIDAÇÃO PARA ADOÇÃO ---");

        boolean adotanteValido = adotante.validar();
        boolean animalValido = cao.validar();

        System.out.println("Adotante '" + adotante.getNome() + "' é válido? " + adotanteValido);
        System.out.println("Animal '" + cao.getNome() + "' está disponível para adoção? " + animalValido);

        System.out.println("=".repeat(50) + "\n");

        // --- Tenta realizar o processo de adoção se ambos forem válidos ---
        if (adotanteValido && animalValido) {
            System.out.println("--- 2. REALIZANDO ADOÇÃO ---");
            Adocao processoAdocao = new Adocao(adotante, cao, new Date(), true);
            System.out.println("Adoção registrada com sucesso!");
            System.out.println(processoAdocao);
            System.out.println("=".repeat(50) + "\n");
        } else {
            System.out.println("!!! PROCESSO DE ADOÇÃO BLOQUEADO: Adotante ou animal inválido. !!!\n");
        }

        // --- Geração de Relatórios ---
        System.out.println("--- 3. GERAÇÃO DE RELATÓRIOS ---");
        System.out.println(adotante.gerarRelatorio());
        System.out.println(cao.gerarRelatorio());
        System.out.println(gato.gerarRelatorio());
    }
}