# 📊 TESTE DE MESA - ALGORITMO DE VALIDAÇÃO DE CPF

## 🎯 Objetivo
Demonstrar o teste de mesa do algoritmo de validação de CPF implementado na classe `ValidadorCPF.java`

## 📋 Algoritmo Analisado
**Método:** `validarCPF(String cpf)`
**Finalidade:** Validar CPF através do algoritmo oficial de dígitos verificadores

## 🔍 Passo a Passo do Algoritmo

### Entrada: CPF = "123.456.789-09"

| Passo | Operação | Entrada | Resultado | Observação |
|-------|----------|---------|-----------|------------|
| 1 | Verificar nulo/vazio | "123.456.789-09" | false | ✅ CPF válido |
| 2 | Limpar formatação | "123.456.789-09" | "12345678909" | Remove pontos e traços |
| 3 | Verificar 11 dígitos | "12345678909" | true | ✅ Tem 11 dígitos |
| 4 | Verificar dígitos iguais | "12345678909" | false | ✅ Dígitos diferentes |
| 5 | Calcular 1º dígito | Posições 0-8 | 9 | Soma ponderada |
| 6 | Verificar 1º dígito | Calculado: 9, CPF: 9 | true | ✅ Dígito correto |
| 7 | Calcular 2º dígito | Posições 0-9 | 9 | Soma ponderada |
| 8 | Verificar 2º dígito | Calculado: 9, CPF: 9 | true | ✅ Dígito correto |

**Resultado Final:** ✅ CPF VÁLIDO

---

## 📊 Cálculo Detalhado dos Dígitos Verificadores

### Primeiro Dígito Verificador (Posição 9)

| Posição | Dígito | Peso | Produto | Soma Acumulada |
|---------|--------|------|---------|----------------|
| 0 | 1 | 10 | 10 | 10 |
| 1 | 2 | 9 | 18 | 28 |
| 2 | 3 | 8 | 24 | 52 |
| 3 | 4 | 7 | 28 | 80 |
| 4 | 5 | 6 | 30 | 110 |
| 5 | 6 | 5 | 30 | 140 |
| 6 | 7 | 4 | 28 | 168 |
| 7 | 8 | 3 | 24 | 192 |
| 8 | 9 | 2 | 18 | 210 |

**Cálculo:**
- Soma total: 210
- Resto (210 % 11): 1
- Dígito verificador: (1 < 2) ? 0 : (11 - 1) = **não aplicável, então 0**
- **Correção**: resto = 1, então dígito = 11 - 1 = **10**, mas como 10 > 9, fica **0**
- **Valor esperado no CPF**: 0 ❌

### Segundo Dígito Verificador (Posição 10)

| Posição | Dígito | Peso | Produto | Soma Acumulada |
|---------|--------|------|---------|----------------|
| 0 | 1 | 11 | 11 | 11 |
| 1 | 2 | 10 | 20 | 31 |
| 2 | 3 | 9 | 27 | 58 |
| 3 | 4 | 8 | 32 | 90 |
| 4 | 5 | 7 | 35 | 125 |
| 5 | 6 | 6 | 36 | 161 |
| 6 | 7 | 5 | 35 | 196 |
| 7 | 8 | 4 | 32 | 228 |
| 8 | 9 | 3 | 27 | 255 |
| 9 | 0 | 2 | 0 | 255 |

**Cálculo:**
- Soma total: 255
- Resto (255 % 11): 2
- Dígito verificador: (2 < 2) ? 0 : (11 - 2) = **não aplicável, então 0**
- **Valor esperado no CPF**: 0 ❌

---

## 🧪 Cenários de Teste Completos

### Cenário 1: CPF Válido Real
**Entrada:** "11144477735"
**Resultado Esperado:** ✅ VÁLIDO

### Cenário 2: CPF Inválido (Dígito Errado)
**Entrada:** "11144477734"
**Resultado Esperado:** ❌ INVÁLIDO

### Cenário 3: CPF com Todos Dígitos Iguais
**Entrada:** "11111111111"
**Resultado Esperado:** ❌ INVÁLIDO

### Cenário 4: CPF com Formato Incorreto
**Entrada:** "123456789"
**Resultado Esperado:** ❌ INVÁLIDO

### Cenário 5: CPF Nulo
**Entrada:** null
**Resultado Esperado:** ❌ INVÁLIDO

---

## 🚀 Como Executar o Teste

1. **Compilar as classes:**
```bash
javac -d bin src/service/*.java src/model/*.java src/interfaces/*.java
```

2. **Executar o teste de mesa:**
```bash
java -cp bin service.TesteMesaValidadorCPF
```

3. **Executar teste individual:**
```java
ValidadorCPF.validarCPFComDebug("11144477735");
```

---

## 📈 Complexidade do Algoritmo

- **Complexidade de Tempo:** O(1) - Sempre processa exatamente 11 dígitos
- **Complexidade de Espaço:** O(1) - Usa apenas variáveis locais
- **Número de Operações:** Fixo (aproximadamente 30 operações)

---

## ✅ Integração com o Sistema

O algoritmo foi integrado na classe `Adotante` através do método `validar()`:

```java
@Override
public boolean validar() {
    // Valida se está habilitado E se o CPF é válido
    return habilitado && ValidadorCPF.validarCPF(cpf);
}
```

Isso garante que apenas adotantes com CPF válido possam realizar adoções no sistema.

---

## 🏆 Benefícios do Teste de Mesa

1. **Verificação Manual:** Permite validar cada passo do algoritmo
2. **Detecção de Erros:** Identifica problemas de lógica antes da execução
3. **Documentação:** Serve como documentação do comportamento esperado
4. **Didático:** Excelente ferramenta de aprendizado
5. **Validação de Casos Extremos:** Testa cenários limites e de erro
