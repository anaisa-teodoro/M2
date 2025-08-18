package service;

/**
 * Classe utilitária para validação de CPF
 * Algoritmo simples e didático para demonstração de teste de mesa
 */
public class ValidadorCPF {
    
    /**
     * Valida se um CPF é válido através do algoritmo de dígitos verificadores
     * @param cpf String contendo o CPF a ser validado
     * @return true se o CPF for válido, false caso contrário
     */
    public static boolean validarCPF(String cpf) {
        // Passo 1: Verificar se CPF é nulo ou vazio
        if (cpf == null || cpf.trim().isEmpty()) {
            return false;
        }
        
        // Passo 2: Remover pontos, traços e espaços
        cpf = cpf.replaceAll("[^0-9]", "");
        
        // Passo 3: Verificar se tem exatamente 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }
        
        // Passo 4: Verificar se não são todos os dígitos iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
        
        // Passo 5: Calcular primeiro dígito verificador
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma1 += digito * (10 - i);
        }
        
        int resto1 = soma1 % 11;
        int digitoVerificador1 = (resto1 < 2) ? 0 : (11 - resto1);
        
        // Passo 6: Verificar se o primeiro dígito verificador está correto
        if (digitoVerificador1 != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }
        
        // Passo 7: Calcular segundo dígito verificador
        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma2 += digito * (11 - i);
        }
        
        int resto2 = soma2 % 11;
        int digitoVerificador2 = (resto2 < 2) ? 0 : (11 - resto2);
        
        // Passo 8: Verificar se o segundo dígito verificador está correto
        return digitoVerificador2 == Character.getNumericValue(cpf.charAt(10));
    }
    
    /**
     * Método auxiliar para demonstrar o passo a passo do algoritmo
     * @param cpf CPF a ser validado com debug
     */
    public static void validarCPFComDebug(String cpf) {
        System.out.println("=== TESTE DE MESA - VALIDAÇÃO DE CPF ===");
        System.out.println("CPF de entrada: " + cpf);
        
        // Passo 1
        if (cpf == null || cpf.trim().isEmpty()) {
            System.out.println("Passo 1: CPF nulo ou vazio - INVÁLIDO");
            return;
        }
        System.out.println("Passo 1: CPF não é nulo/vazio ✓");
        
        // Passo 2
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        System.out.println("Passo 2: CPF após limpeza: " + cpfLimpo);
        
        // Passo 3
        if (cpfLimpo.length() != 11) {
            System.out.println("Passo 3: CPF não tem 11 dígitos (" + cpfLimpo.length() + ") - INVÁLIDO");
            return;
        }
        System.out.println("Passo 3: CPF tem 11 dígitos ✓");
        
        // Passo 4
        if (cpfLimpo.matches("(\\d)\\1{10}")) {
            System.out.println("Passo 4: Todos os dígitos são iguais - INVÁLIDO");
            return;
        }
        System.out.println("Passo 4: Dígitos não são todos iguais ✓");
        
        // Passo 5: Primeiro dígito verificador
        System.out.println("\n--- CÁLCULO DO PRIMEIRO DÍGITO VERIFICADOR ---");
        int soma1 = 0;
        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cpfLimpo.charAt(i));
            int peso = 10 - i;
            int produto = digito * peso;
            soma1 += produto;
            System.out.printf("Posição %d: %d x %d = %d (soma parcial: %d)\n", 
                            i, digito, peso, produto, soma1);
        }
        
        int resto1 = soma1 % 11;
        int digitoVerificador1 = (resto1 < 2) ? 0 : (11 - resto1);
        System.out.printf("Soma total: %d | Resto da divisão por 11: %d\n", soma1, resto1);
        System.out.printf("Primeiro dígito verificador calculado: %d\n", digitoVerificador1);
        System.out.printf("Primeiro dígito do CPF: %d\n", Character.getNumericValue(cpfLimpo.charAt(9)));
        
        if (digitoVerificador1 != Character.getNumericValue(cpfLimpo.charAt(9))) {
            System.out.println("Passo 6: Primeiro dígito verificador INCORRETO - INVÁLIDO");
            return;
        }
        System.out.println("Passo 6: Primeiro dígito verificador correto ✓");
        
        // Passo 7: Segundo dígito verificador
        System.out.println("\n--- CÁLCULO DO SEGUNDO DÍGITO VERIFICADOR ---");
        int soma2 = 0;
        for (int i = 0; i < 10; i++) {
            int digito = Character.getNumericValue(cpfLimpo.charAt(i));
            int peso = 11 - i;
            int produto = digito * peso;
            soma2 += produto;
            System.out.printf("Posição %d: %d x %d = %d (soma parcial: %d)\n", 
                            i, digito, peso, produto, soma2);
        }
        
        int resto2 = soma2 % 11;
        int digitoVerificador2 = (resto2 < 2) ? 0 : (11 - resto2);
        System.out.printf("Soma total: %d | Resto da divisão por 11: %d\n", soma2, resto2);
        System.out.printf("Segundo dígito verificador calculado: %d\n", digitoVerificador2);
        System.out.printf("Segundo dígito do CPF: %d\n", Character.getNumericValue(cpfLimpo.charAt(10)));
        
        if (digitoVerificador2 == Character.getNumericValue(cpfLimpo.charAt(10))) {
            System.out.println("Passo 8: Segundo dígito verificador correto ✓");
            System.out.println("\n🎉 RESULTADO: CPF VÁLIDO!");
        } else {
            System.out.println("Passo 8: Segundo dígito verificador INCORRETO - INVÁLIDO");
            System.out.println("\n❌ RESULTADO: CPF INVÁLIDO!");
        }
    }
}
