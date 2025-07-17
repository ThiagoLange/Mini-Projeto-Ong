package com.example.animais.gestao;

import com.example.animais.interfaces.Relatorio;
import com.example.animais.interfaces.Validavel;

/**
 * A classe Adotante agora implementa as interfaces Validavel e Relatorio.
 */
public class Adotante extends Pessoa implements Validavel, Relatorio {

    private String preferencias;

    // ... (construtor, getter e setter existentes não mudam)
    public Adotante(String nome, String cpf, String endereco, String telefone, String preferencias) {
        super(nome, cpf, endereco, telefone);
        this.preferencias = preferencias;
    }
    public String getPreferencias() { return preferencias; }
    public void setPreferencias(String preferencias) { this.preferencias = preferencias; }

    // --- IMPLEMENTAÇÃO DA INTERFACE VALIDAVEL ---
    /**
     * Valida se o adotante possui os dados mínimos necessários.
     * @return true se nome, CPF e endereço não estiverem vazios.
     */
    @Override
    public boolean validar() {
        return getNome() != null && !getNome().trim().isEmpty() &&
                getCpf() != null && !getCpf().trim().isEmpty() &&
                getEndereco() != null && !getEndereco().trim().isEmpty();
    }

    // --- IMPLEMENTAÇÃO DA INTERFACE RELATORIO ---
    /**
     * Gera um relatório completo com os dados do adotante.
     * @return Uma String com o relatório.
     */
    @Override
    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== RELATÓRIO DO ADOTANTE =====\n");
        sb.append("Nome: ").append(getNome()).append("\n");
        sb.append("CPF: ").append(getCpf()).append("\n");
        sb.append("Endereço: ").append(getEndereco()).append("\n");
        sb.append("Telefone: ").append(getTelefone()).append("\n");
        sb.append("Preferências de Adoção: ").append(preferencias).append("\n");
        sb.append("===============================\n");
        return sb.toString();
    }

    // ... (toString não muda)
    @Override
    public String toString() { return "Adotante{" + "nome='" + getNome() + '\'' + ", cpf='" + getCpf() + '\'' + ", endereco='" + getEndereco() + '\'' + ", telefone='" + getTelefone() + '\'' + ", preferencias='" + preferencias + '\'' + '}'; }
}