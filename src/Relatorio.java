package com.example.animais.interfaces;

/**
 * Interface que define um contrato para objetos que podem gerar
 * um relatório em formato de String sobre si mesmos.
 */
@FunctionalInterface
public interface Relatorio {

    /**
     * Gera uma representação textual detalhada do objeto.
     * @return Uma String contendo o relatório.
     */
    String gerarRelatorio();
}