-- ========================================
-- EXERCÍCIO 04 - Consultas avançadas no banco ambiente_sustentavel
-- ========================================

USE ambiente_sustentavel;

SELECT * 
FROM Usuario 
WHERE data_cadastro > '2024-01-01';


SELECT * 
FROM Projeto 
WHERE nome LIKE '%Energia%';


SELECT * 
FROM Usuario 
ORDER BY nome ASC;
