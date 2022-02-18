package br.uninove.poo;

//nome do objeto
public class Pessoa {

    //atributos (características)
    String nome;
    String cpf;
    int idade;
    char sexo;

    //métodos (comportamento)
    void fazerAniversario() {
        idade++; //é o mesmo que: idade = idade + 1;
        System.out.println("Ôba festinha do balacobaco!");
    }

    void nascer() {
        idade = 0;
    }
}
