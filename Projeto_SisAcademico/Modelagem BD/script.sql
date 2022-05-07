-- Script completo do Banco de dados de nosso projeto

-- Tabela de cursos:
CREATE TABLE tb_curso(
    id_curso INT PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1 INCREMENT BY 1),
    nome_curso VARCHAR(90) NOT NULL,
    tipo_curso VARCHAR(50)
);

-- Tabela de alunos:
CREATE TABLE tb_aluno(
    id INT PRIMARY KEY
    GENERATED ALWAYS AS IDENTITY
    (START WITH 1, INCREMENT BY 1),
    ra INT NOT NULL,
    nome VARCHAR(100),
    id_curso INT,
        CONSTRAINT fk_aluno_curso 
        FOREIGN KEY(id_curso) REFERENCES tb_curso
)