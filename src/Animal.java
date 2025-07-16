package com.example.animais.model;

import java.util.Objects;

/**
 * Representa a base para a criação de animais, contendo os atributos e
 * comportamentos comuns a todos.
 * Esta classe é abstrata e não pode ser instanciada diretamente.
 */
public abstract class Animal {

    private String id;
    private String nome;
    private String especie;
    private int idade;
    private String condicaoSaude;
    private String temperamento;
    private String status; // Ex: "Disponível para adoção", "Adotado", "Em tratamento"

    public Animal(String id, String nome, String especie, int idade, String condicaoSaude, String temperamento, String status) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.condicaoSaude = condicaoSaude;
        this.temperamento = temperamento;
        this.status = status;
    }

    // --- Getters e Setters ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCondicaoSaude() {
        return condicaoSaude;
    }

    public void setCondicaoSaude(String condicaoSaude) {
        this.condicaoSaude = condicaoSaude;
    }

    public String getTemperamento() {
        return temperamento;
    }

    public void setTemperamento(String temperamento) {
        this.temperamento = temperamento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // --- Sobrescrita de Métodos Padrão ---

    @Override
    public String toString() {
        return "Animal{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", idade=" + idade +
                ", condicaoSaude='" + condicaoSaude + '\'' +
                ", temperamento='" + temperamento + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}