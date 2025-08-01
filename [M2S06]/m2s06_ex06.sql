-- ========================================
-- EXERCÍCIO 06 - Comando DELETE no banco ambiente_sustentavel
-- ========================================

USE ambiente_sustentavel;

SELECT * 
FROM Projeto 
WHERE data_inicio > '2025-06-30';


DELETE FROM Projeto 
WHERE data_inicio > '2025-06-30';


SELECT * FROM Projeto;
