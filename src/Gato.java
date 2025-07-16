package com.example.animais.model;

/**
 * Representa um animal da espécie Gato, herdando as características
 * da classe Animal e adicionando atributos específicos.
 */
public class Gato extends Animal {

    private boolean conviveComOutrosGatos;

    public Gato(String id, String nome, int idade, String condicaoSaude, String temperamento, String status, boolean conviveComOutrosGatos) {
        // Chama o construtor da classe pai (Animal)
        super(id, nome, "Gato", idade, condicaoSaude, temperamento, status);
        this.conviveComOutrosGatos = conviveComOutrosGatos;
    }

    // --- Getter e Setter Específico ---

    public boolean isConviveComOutrosGatos() {
        return conviveComOutrosGatos;
    }

    public void setConviveComOutrosGatos(boolean conviveComOutrosGatos) {
        this.conviveComOutrosGatos = conviveComOutrosGatos;
    }

    // --- Sobrescrita do Método toString ---

    @Override
    public String toString() {
        return "Gato{" +
                "id='" + getId() + '\'' +
                ", nome='" + getNome() + '\'' +
                ", especie='" + getEspecie() + '\'' +
                ", idade=" + getIdade() +
                ", condicaoSaude='" + getCondicaoSaude() + '\'' +
                ", temperamento='" + getTemperamento() + '\'' +
                ", status='" + getStatus() + '\'' +
                ", conviveComOutrosGatos=" + conviveComOutrosGatos +
                '}';
    }
}