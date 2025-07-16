package com.example.animais.gestao;

import com.example.animais.model.Animal;
import java.util.Date;
import java.util.UUID;

/**
 * Representa o registro do processo de adoção, vinculando um Adotante a um Animal.
 */
public class Adocao {

    private final String id; // ID único para o registro de adoção
    private Adotante adotante;
    private Animal animalAdotado;
    private Date data;
    private boolean termoAssinado;

    public Adocao(Adotante adotante, Animal animalAdotado, Date data, boolean termoAssinado) {
        this.id = UUID.randomUUID().toString(); // Gera um ID único
        this.adotante = adotante;
        this.animalAdotado = animalAdotado;
        this.data = data;
        this.termoAssinado = termoAssinado;

        // Boa prática: ao registrar uma adoção, atualizar o status do animal
        if (termoAssinado) {
            this.animalAdotado.setStatus("Adotado");
        }
    }

    // --- Getters e Setters ---

    public String getId() {
        return id;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }

    public Animal getAnimalAdotado() {
        return animalAdotado;
    }

    public void setAnimalAdotado(Animal animalAdotado) {
        this.animalAdotado = animalAdotado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isTermoAssinado() {
        return termoAssinado;
    }

    public void setTermoAssinado(boolean termoAssinado) {
        this.termoAssinado = termoAssinado;
    }

    // --- Método toString ---

    @Override
    public String toString() {
        return "Adocao{" +
                "id='" + id + '\'' +
                ", data=" + data +
                ", termoAssinado=" + termoAssinado +
                "\n  --> Adotante: " + adotante.getNome() + " (CPF: " + adotante.getCpf() + ")" +
                "\n  --> Animal: " + animalAdotado.getNome() + " (ID: " + animalAdotado.getId() + ")" +
                '}';
    }
}