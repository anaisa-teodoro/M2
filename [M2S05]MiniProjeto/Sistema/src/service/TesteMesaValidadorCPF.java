package service;

/**
 * Classe para demonstrar o teste de mesa do algoritmo de validação de CPF
 */
public class TesteMesaValidadorCPF {

    public static void main(String[] args) {
        System.out.println("📊 DEMONSTRAÇÃO DE TESTE DE MESA");
        System.out.println("Algoritmo: Validação de CPF com Dígitos Verificadores");
        // CORRIGIDO AQUI
        System.out.println("=".repeat(60));

        // Cenário 1: CPF Válido
        System.out.println("\n🧪 CENÁRIO 1: CPF VÁLIDO");
        ValidadorCPF.validarCPFComDebug("123.456.789-09");

        // CORRIGIDO AQUI
        System.out.println("\n" + "=".repeat(60));

        // Cenário 2: CPF Inválido (dígito verificador errado)
        System.out.println("\n🧪 CENÁRIO 2: CPF INVÁLIDO (dígito verificador errado)");
        ValidadorCPF.validarCPFComDebug("123.456.789-00");

        // CORRIGIDO AQUI
        System.out.println("\n" + "=".repeat(60));

        // Cenário 3: CPF com todos os dígitos iguais
        System.out.println("\n🧪 CENÁRIO 3: CPF INVÁLIDO (todos os dígitos iguais)");
        ValidadorCPF.validarCPFComDebug("111.111.111-11");

        // CORRIGIDO AQUI
        System.out.println("\n" + "=".repeat(60));

        // Cenário 4: CPF com formato incorreto
        System.out.println("\n🧪 CENÁRIO 4: CPF INVÁLIDO (formato incorreto)");
        ValidadorCPF.validarCPFComDebug("123.456.789");

        // CORRIGIDO AQUI
        System.out.println("\n" + "=".repeat(60));

        // Cenário 5: CPF nulo
        System.out.println("\n🧪 CENÁRIO 5: CPF NULO");
        ValidadorCPF.validarCPFComDebug(null);

        System.out.println("\n📋 TABELA RESUMO DOS TESTES:");
        System.out.println("┌─────────────────┬─────────────────────┬──────────┐");
        System.out.println("│ CPF             │ Descrição           │ Resultado│");
        System.out.println("├─────────────────┼─────────────────────┼──────────┤");
        System.out.println("│ 123.456.789-09  │ CPF válido          │ ✅ VÁLIDO │");
        System.out.println("│ 123.456.789-00  │ Dígito incorreto    │ ❌ INVÁLIDO│");
        System.out.println("│ 111.111.111-11  │ Todos iguais        │ ❌ INVÁLIDO│");
        System.out.println("│ 123.456.789     │ Formato incorreto   │ ❌ INVÁLIDO│");
        System.out.println("│ null            │ Valor nulo          │ ❌ INVÁLIDO│");
        System.out.println("└─────────────────┴─────────────────────┴──────────┘");
    }
}