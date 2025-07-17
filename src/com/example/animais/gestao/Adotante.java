package com.example.animais.gestao;

import com.example.animais.interfaces.Relatorio;
import com.example.animais.interfaces.Validavel;

/**
 * A classe Adotante agora implementa as interfaces Validavel e Relatorio.
 * E possui um status para habilitar ou desabilitar o adotante.
 */
public class Adotante extends Pessoa implements Validavel, Relatorio {

    private String preferencias;
    private boolean aptoParaAdocao; // Novo atributo para controlar o status

    public Adotante(String nome, String cpf, String endereco, String telefone, String preferencias) {
        super(nome, cpf, endereco, telefone);
        this.preferencias = preferencias;
        this.aptoParaAdocao = true; // Por padrão, um novo adotante está apto
    }

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }

    public boolean isAptoParaAdocao() {
        return aptoParaAdocao;
    }

    public void setAptoParaAdocao(boolean aptoParaAdocao) {
        this.aptoParaAdocao = aptoParaAdocao;
    }

    // --- IMPLEMENTAÇÃO DA INTERFACE VALIDAVEL ---
    /**
     * Valida se o adotante possui os dados mínimos necessários E se está apto para adoção.
     * @return true se os dados são válidos e o adotante está apto.
     */
    @Override
    public boolean validar() {
        // A validação agora também verifica se o adotante está apto
        return isAptoParaAdocao() &&
                getNome() != null && !getNome().trim().isEmpty() &&
                getCpf() != null && !getCpf().trim().isEmpty() &&
                getEndereco() != null && !getEndereco().trim().isEmpty();
    }

    // --- IMPLEMENTAÇÃO DA INTERFACE RELATORIO ---
    /**
     * Gera um relatório completo com os dados do adotante, incluindo o status.
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
        sb.append("Status: ").append(isAptoParaAdocao() ? "Apto para Adoção" : "Inapto para Adoção").append("\n");
        sb.append("===============================\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Adotante{" +
                "nome='" + getNome() + '\'' +
                ", cpf='" + getCpf() + '\'' +
                ", status=" + (isAptoParaAdocao() ? "Apto" : "Inapto") +
                '}';
    }
}