package br.sisacademico.dao;

import br.sisacademico.model.Aluno;
import br.sisacademico.model.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlunoDao {
    
    private static Statement stm;

    public ArrayList<Aluno> getAlunos() throws SQLException {
        ArrayList<Aluno> alunos = new ArrayList<>();

        String query = "SELECT"
                + "    aluno.ID,"
                + "    aluno.RA,"
                + "    aluno.NOME,"
                + "    curso.ID_CURSO,"
                + "    curso.NOME_CURSO,"
                + "    curso.TIPO_CURSO"
                + " FROM"
                + "    TB_ALUNO as aluno"
                + "    INNER JOIN TB_CURSO as curso"
                + "        ON aluno.ID_CURSO = curso.ID_CURSO";
        
        query += " ORDER BY aluno.NOME";
        
        stm = ConnectionFactory.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        
        ResultSet resultados = stm.executeQuery(query);
        
        while(resultados.next()) {
            Aluno a = new Aluno();
            Curso c = new Curso();
            
            a.setIdAluno(resultados.getInt("ID"));
            a.setNome(resultados.getString("NOME"));
            a.setRa(resultados.getInt("RA"));
            
            c.setIdCurso(resultados.getInt("ID_CURSO"));
            c.setNomeCurso(resultados.getString("NOME_CURSO"));
            c.setTipoCurso(resultados.getString("TIPO_CURSO"));
            
            a.setCurso(c);
            
            alunos.add(a);
        }
        
        stm.getConnection().close();
        
        return alunos;
    }
    
    public boolean deleteAluno(int idAluno) {
        try {
            String query = "DELETE FROM tb_aluno WHERE id = ?";
            PreparedStatement stm = ConnectionFactory.getConnection()
                    .prepareCall(query);
            stm.setInt(1, idAluno);
            stm.execute();
            stm.getConnection().close();
            return true;
        } catch(Exception ex) {
            return false;
        }
    }
}
