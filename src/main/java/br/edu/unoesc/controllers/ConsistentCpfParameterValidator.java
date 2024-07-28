package br.edu.unoesc.controllers;

import br.edu.unoesc.annotations.CpfValidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConsistentCpfParameterValidator implements ConstraintValidator<CpfValidator, String>{

    @Override
    public void initialize(CpfValidator constraintAnnotation) {
        // Inicialização, se necessário
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        // Lógica de validação do CPF
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }

        // Verifique se o CPF tem 11 dígitos e se é válido
        return isValidCPF(cpf);
    }

    private boolean isValidCPF(String cpf) {
        // Remover caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Validação dos dígitos verificadores
        int[] cpfDigits = cpf.chars().map(Character::getNumericValue).toArray();
        int sum = 0;

        // Calcular o primeiro dígito verificador
        for (int i = 0; i < 9; i++) {
            sum += cpfDigits[i] * (10 - i);
        }
        int firstDigit = (sum * 10) % 11;
        if (firstDigit == 10) firstDigit = 0;

        if (cpfDigits[9] != firstDigit) {
            return false;
        }

        // Calcular o segundo dígito verificador
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += cpfDigits[i] * (11 - i);
        }
        int secondDigit = (sum * 10) % 11;
        if (secondDigit == 10) secondDigit = 0;

        return cpfDigits[10] == secondDigit;
    }
	
}