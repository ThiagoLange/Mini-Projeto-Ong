package com.example.animais.model;

import com.example.animais.interfaces.Relatorio;
import com.example.animais.interfaces.Validavel;
import java.util.Objects;

/**
 * Classe abstrata Animal agora implementa as interfaces Validavel e Relatorio.
 */
public abstract class Animal implements Validavel, Relatorio {

    // ... (atributos existentes: id, nome, etc. não mudam)
    private String id;
    private String nome;
    private String especie;
    private int idade;
    private String condicaoSaude;
    private String temperamento;
    private String status;

    // ... (construtor existente não muda)
    public Animal(String id, String nome, String especie, int idade, String condicaoSaude, String temperamento, String status) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.condicaoSaude = condicaoSaude;
        this.temperamento = temperamento;
        this.status = status;
    }

    // ... (Getters e Setters existentes não mudam)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }
    public String getCondicaoSaude() { return condicaoSaude; }
    public void setCondicaoSaude(String condicaoSaude) { this.condicaoSaude = condicaoSaude; }
    public String getTemperamento() { return temperamento; }
    public void setTemperamento(String temperamento) { this.temperamento = temperamento; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


    // --- IMPLEMENTAÇÃO DA INTERFACE VALIDAVEL ---
    /**
     * Valida se o animal está apto para adoção.
     * A regra base é verificar se o status é "Disponível para adoção".
     * @return true se o animal estiver disponível, false caso contrário.
     */
    @Override
    public boolean validar() {
        return this.status != null && this.status.equalsIgnoreCase("Disponível para adoção");
    }

    // --- IMPLEMENTAÇÃO DA INTERFACE RELATORIO ---
    /**
     * Gera um relatório com os dados básicos do animal.
     * As subclasses podem estender este relatório.
     * @return String com o relatório básico.
     */
    @Override
    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== RELATÓRIO DO ANIMAL =====\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Espécie: ").append(especie).append("\n");
        sb.append("Idade: ").append(idade).append(" anos\n");
        sb.append("Condição de Saúde: ").append(condicaoSaude).append("\n");
        sb.append("Temperamento: ").append(temperamento).append("\n");
        sb.append("Status Atual: ").append(status).append("\n");
        return sb.toString();
    }

    // ... (métodos toString, equals e hashCode existentes não mudam)
    @Override
    public String toString() {
        return "Animal{" + "id='" + id + '\'' + ", nome='" + nome + '\'' + ", especie='" + especie + '\'' + ", idade=" + idade + ", condicaoSaude='" + condicaoSaude + '\'' + ", temperamento='" + temperamento + '\'' + ", status='" + status + '\'' + '}';
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