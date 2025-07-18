package com.example.animais.gestao;

import com.example.animais.model.Animal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Representa o registro do processo de adoção, vinculando um Adotante a um Animal.
 */
public class Adocao {

    private final String id;
    private Adotante adotante;
    private Animal animalAdotado;
    private Date data;
    private boolean termoAssinado;

    public Adocao(Adotante adotante, Animal animalAdotado) {
        this.id = UUID.randomUUID().toString(); // Gera um ID único
        this.adotante = adotante;
        this.animalAdotado = animalAdotado;
        this.data = new Date(); // Define a data de registro da adoção
        this.termoAssinado = false; // Adoção começa como pendente
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

    // Método para formalizar a adoção
    /**
     * Finaliza o processo de adoção, assinando o termo e
     * atualizando o status do animal para "Adotado".
     */
    public void realizarAdoção() {
        this.termoAssinado = true;
        this.animalAdotado.setStatus("Adotado");
    }

    // --- Método toString ---

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Adocao {" +
                "id='" + id + '\'' +
                ", data=" + sdf.format(data) +
                ", Status do Termo=" + (termoAssinado ? "Assinado (Realizada)" : "Pendente") +
                "\n  --> Adotante: " + adotante.getNome() + " (CPF: " + adotante.getCpf() + ")" +
                "\n  --> Animal: " + animalAdotado.getNome() + " (ID: " + animalAdotado.getId() + ")" +
                '}';
    }
}