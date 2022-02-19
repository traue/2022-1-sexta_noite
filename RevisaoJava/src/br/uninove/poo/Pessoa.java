package br.uninove.poo;

//nome do objeto
public class Pessoa {

    //atributos (características)
    private String nome;
    private String cpf;
    private int idade;
    private char sexo;

    //método construtor:
    public Pessoa() {
        nome = "";
        cpf = "";
        idade = 0;
        sexo = 'I';
    }

    //sobrecarregar o construtor
    //Assinatura do método: String String, int char
    public Pessoa(String nome, String cpf, int idade, char sexo) {
        //o "this" refere-se ao atributo local da classe (definido "lá em cima")
        //a variável sem o "this" em frente, refere-se à veriável recebida via parâmetro no método
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
    }

    //métodos (comportamento)
    void fazerAniversario() {
        setIdade(getIdade() + 1); //é o mesmo que: idade = idade + 1;
        System.out.println("Ôba festinha do balacobaco!");
    }

    void nascer() {
        setIdade(0);
    }

    //encapsulamento:
    //1º para cada atributo transformá-los em privado (private)
    //2º criar um set para o atributo
    //3º criar um get para o atriburo
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0 || idade > 150) { //por algun motivo definimos essa regra de negócio
            this.idade = -999;
        } else {
            this.idade = idade;
        }
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

}
