package com.example.animais.model;

public class Cao extends Animal {

    private String porte;
    private boolean necessitaPasseio;

    // ... (construtor, getters e setters não mudam)
    public Cao(String id, String nome, int idade, String condicaoSaude, String temperamento, String status, String porte, boolean necessitaPasseio) {
        super(id, nome, "Cachorro", idade, condicaoSaude, temperamento, status);
        this.porte = porte;
        this.necessitaPasseio = necessitaPasseio;
    }
    public String getPorte() { return porte; }
    public void setPorte(String porte) { this.porte = porte; }
    public boolean isNecessitaPasseio() { return necessitaPasseio; }
    public void setNecessitaPasseio(boolean necessitaPasseio) { this.necessitaPasseio = necessitaPasseio; }

    /**
     * Sobrescreve o método para adicionar informações específicas do cão ao relatório.
     */
    @Override
    public String gerarRelatorio() {
        String relatorioBase = super.gerarRelatorio(); // Reutiliza o relatório da classe pai
        StringBuilder sb = new StringBuilder(relatorioBase);
        sb.append("--- Detalhes Específicos (Cão) ---\n");
        sb.append("Porte: ").append(this.porte).append("\n");
        sb.append("Necessita de Passeio Diário: ").append(this.necessitaPasseio ? "Sim" : "Não").append("\n");
        sb.append("===============================\n");
        return sb.toString();
    }

    // ... (toString não muda)
    @Override
    public String toString() { return "Cao{" + "id='" + getId() + '\'' + ", nome='" + getNome() + '\'' + ", especie='" + getEspecie() + '\'' + ", idade=" + getIdade() + ", condicaoSaude='" + getCondicaoSaude() + '\'' + ", temperamento='" + getTemperamento() + '\'' + ", status='" + getStatus() + '\'' + ", porte='" + porte + '\'' + ", necessitaPasseio=" + necessitaPasseio + '}'; }
}