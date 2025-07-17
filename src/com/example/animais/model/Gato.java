package com.example.animais.model;

public class Gato extends Animal {

    private boolean conviveComOutrosGatos;

    // ... (construtor, getters e setters não mudam)
    public Gato(String id, String nome, int idade, String condicaoSaude, String temperamento, String status, boolean conviveComOutrosGatos) {
        super(id, nome, "Gato", idade, condicaoSaude, temperamento, status);
        this.conviveComOutrosGatos = conviveComOutrosGatos;
    }
    public boolean isConviveComOutrosGatos() { return conviveComOutrosGatos; }
    public void setConviveComOutrosGatos(boolean conviveComOutrosGatos) { this.conviveComOutrosGatos = conviveComOutrosGatos; }

    /**
     * Sobrescreve o método para adicionar informações específicas do gato ao relatório.
     */
    @Override
    public String gerarRelatorio() {
        String relatorioBase = super.gerarRelatorio(); // Reutiliza o relatório da classe pai
        StringBuilder sb = new StringBuilder(relatorioBase);
        sb.append("--- Detalhes Específicos (Gato) ---\n");
        sb.append("Convive bem com outros gatos: ").append(this.conviveComOutrosGatos ? "Sim" : "Não").append("\n");
        sb.append("===============================\n");
        return sb.toString();
    }

    // ... (toString não muda)
    @Override
    public String toString() { return "Gato{" + "id='" + getId() + '\'' + ", nome='" + getNome() + '\'' + ", especie='" + getEspecie() + '\'' + ", idade=" + getIdade() + ", condicaoSaude='" + getCondicaoSaude() + '\'' + ", temperamento='" + getTemperamento() + '\'' + ", status='" + getStatus() + '\'' + ", conviveComOutrosGatos=" + conviveComOutrosGatos + '}'; }
}