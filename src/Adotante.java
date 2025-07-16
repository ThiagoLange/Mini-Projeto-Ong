package com.example.animais.gestao;

/**
 * Representa a pessoa interessada em adotar um animal.
 * Herda os dados básicos da classe Pessoa.
 */
public class Adotante extends Pessoa {

    private String preferencias; // Ex: "Prefere cães de porte pequeno", "Gatos que não soltem muito pelo"

    public Adotante(String nome, String cpf, String endereco, String telefone, String preferencias) {
        // Chama o construtor da classe pai (Pessoa) para inicializar os atributos herdados
        super(nome, cpf, endereco, telefone);
        this.preferencias = preferencias;
    }

    // --- Getter e Setter Específico ---

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    // --- Sobrescrita do Método toString para incluir os novos atributos ---

    @Override
    public String toString() {
        return "Adotante{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", preferencias='" + preferencias + '\'' +
                '}';
    }
}