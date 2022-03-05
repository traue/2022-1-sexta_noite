package br.uninove.imc;

public class Imc {

    private float peso;
    private float altura;

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calcularIMC() {
        float imc = peso / (altura * altura);
        return imc;
    }

    /*
        Desafio do tio: 
        Criar um esquema para mostrar a classificação do usuário, 
        baseado nessa tabela:
        https://arquivos.sbn.org.br/equacoes/eq5.htm
     */
}
