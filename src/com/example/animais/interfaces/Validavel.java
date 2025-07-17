package com.example.animais.interfaces;

/**
 * Interface que define um contrato para objetos que podem ser validados.
 * É utilizada para garantir que um Animal ou Adotante atende aos critérios
 * necessários para um processo de adoção.
 */
@FunctionalInterface // Opcional, mas boa prática para interfaces com um único método abstrato
public interface Validavel {

    /**
     * Executa a lógica de validação do objeto.
     * @return true se o objeto é considerado válido, false caso contrário.
     */
    boolean validar();
}