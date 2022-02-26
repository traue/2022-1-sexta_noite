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
        p.setIdade(34);
        p.setSexo('M');

        System.out.println("Nome: " + p.getNome());
        System.out.println("Idade: " + p.getIdade());
        System.out.println("CPF: " + p.getCpf());
        System.out.println("Sexo: " + p.getSexo());

        p.fazerAniversario();

        System.out.println("Agora você tem " + p.getIdade() + " anos!");

        
        Aluno a = new Aluno();
        a.setRa(1234);
        a.setEmail("guigui@uni9.edu.br");
        a.setCurso("BIRL");
        a.setNome("Gui gui");
        a.setCpf("666.6666.777-99");
        a.setIdade(21);
        a.setSexo('G');
    }
}
