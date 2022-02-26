package br.uninove.poo;

                                 //é
public class Aluno extends Pessoa  {
    private int ra;
    private String email;
    private String curso;

    public Aluno(int ra, String email, String curso,
            String nome, String cpf, int idade, char sexo) {
        super(nome, cpf, idade, sexo);
        this.ra = ra;
        this.email = email;
        this.curso  = curso;
    }
    
    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
}