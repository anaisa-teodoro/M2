-- ========================================
-- [M2S06] Ex 2 - Inserção dos dados
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
('Ana Carolina Silva', 'ana.silva@email.com', '2025-07-15'),
('João Pedro Santos', 'joao.santos@email.com', '2025-07-20'),
('Maria Fernanda Costa', 'maria.costa@email.com', '2025-07-25'),
('Carlos Eduardo Lima', 'carlos.lima@email.com', '2025-07-30');


INSERT INTO Projeto (nome, descricao, responsavel_id, data_inicio) VALUES
('Energia Solar Residencial', 'Instalação de painéis solares em residências populares', 1, '2025-08-05'),
('Compostagem Comunitária', 'Sistema de compostagem para aproveitamento de resíduos orgânicos', 2, '2025-08-15'),
('Jardim Vertical Urbano', 'Criação de jardins verticais em espaços urbanos reduzidos', 3, '2025-09-01');

SELECT * FROM Usuario;

SELECT * FROM Projeto;

SELECT 
    p.nome AS projeto,
    p.descricao,
    u.nome AS responsavel,
    p.data_inicio
FROM Projeto p
JOIN Usuario u ON p.responsavel_id = u.id;
