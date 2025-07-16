package com.example.animais.model;

/**
 * Representa um animal da espécie Cão, herdando as características
 * da classe Animal e adicionando atributos específicos.
 */
public class Cao extends Animal {

    private String porte; // Ex: "Pequeno", "Médio", "Grande"
    private boolean necessitaPasseio;

    public Cao(String id, String nome, int idade, String condicaoSaude, String temperamento, String status, String porte, boolean necessitaPasseio) {
        // Chama o construtor da classe pai (Animal) para inicializar os atributos herdados
        super(id, nome, "Cachorro", idade, condicaoSaude, temperamento, status);
        this.porte = porte;
        this.necessitaPasseio = necessitaPasseio;
    }

    // --- Getters e Setters Específicos ---

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public boolean isNecessitaPasseio() {
        return necessitaPasseio;
    }

    public void setNecessitaPasseio(boolean necessitaPasseio) {
        this.necessitaPasseio = necessitaPasseio;
    }

    // --- Sobrescrita do Método toString para incluir os novos atributos ---

    @Override
    public String toString() {
        return "Cao{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", especie='" + getEspecie() + '\'' +
                ", idade=" + getIdade() +
                ", condicaoSaude='" + getCondicaoSaude() + '\'' +
                ", temperamento='" + getTemperamento() + '\'' +
                ", status='" + getStatus() + '\'' +
                ", porte='" + porte + '\'' +
                ", necessitaPasseio=" + necessitaPasseio +
                '}';
    }
}