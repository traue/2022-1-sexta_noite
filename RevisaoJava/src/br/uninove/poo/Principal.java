package br.uninove.poo;

public class Principal {

    public static void main(String[] args) {
        Pessoa p = new Pessoa();

        //p.nome = "Thiago Traue";
        //p.idade = 34;
        //p.cpf = "123.123.123-00";
        //p.sexo = 'M';
        //-------------------------
        //System.out.println("Olá mundo!!!");
        //System.out.println("Olá " + p.nome + " seja bem-vindo(a)!");
        //System.out.println("Ah! legal, você tem " + p.idade + " anos!");
        p.setNome("Thiago G. Traue");
        p.setCpf("123.123.123-00");
        p.setIdade(200);
        p.setSexo('M');

        System.out.println("Nome: " + p.getNome());
        System.out.println("Idade: " + p.getIdade());
        System.out.println("CPF: " + p.getCpf());
        System.out.println("Sexo: " + p.getSexo());

        p.fazerAniversario();

        System.out.println("Agora você tem " + p.getIdade() + " anos!");

    }
}
