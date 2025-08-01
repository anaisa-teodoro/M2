-- ========================================
-- [M2S06] Ex 1 - Criar de banco de dados e suas tabelas
-- ========================================

CREATE DATABASE ambiente_sustentavel;

USE ambiente_sustentavel;


CREATE TABLE Usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    data_cadastro DATE NOT NULL
);

CREATE TABLE Projeto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    responsavel_id INT NOT NULL,
    data_inicio DATE NOT NULL,
    FOREIGN KEY (responsavel_id) REFERENCES Usuario(id)
);

INSERT INTO Usuario (nome, email, data_cadastro) VALUES
('Ana Silva', 'ana@email.com', '2025-07-01'),
('Carlos Santos', 'carlos@email.com', '2025-07-05'),
('Maria Oliveira', 'maria@email.com', '2025-07-10');

INSERT INTO Projeto (nome, descricao, responsavel_id, data_inicio) VALUES
('Energia Solar', 'Projeto de painéis solares', 1, '2025-08-01'),
('Reciclagem', 'Coleta seletiva de lixo', 2, '2025-08-15'),
('Horta Urbana', 'Hortas em prédios', 3, '2025-09-01');

SELECT * FROM Usuario;

SELECT * FROM Projeto;

SELECT 
    p.nome AS projeto,
    p.descricao,
    u.nome AS responsavel,
    p.data_inicio
FROM Projeto p
JOIN Usuario u ON p.responsavel_id = u.id;