-- ========================================
-- EXERCÍCIO 05 - Comandos UPDATE no banco ambiente_sustentavel
-- ========================================

USE ambiente_sustentavel;

UPDATE Usuario 
SET email = 'maria.costa.novo@email.com' 
WHERE id = 3;


UPDATE Projeto 
SET nome = 'Reflorestamento' 
WHERE id = 2;


SELECT * FROM Usuario WHERE id = 3;


SELECT * FROM Projeto WHERE id = 2;
