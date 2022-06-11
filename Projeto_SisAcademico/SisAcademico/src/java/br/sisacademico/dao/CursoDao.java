package br.sisacademico.dao;

import br.sisacademico.model.Curso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class CursoDao {

    private static Statement stm;

    public Map<Curso, Integer> getCursosCountAlunos() throws SQLException {

        Map<Curso, Integer> resultado = new LinkedHashMap<>();

        String query = "SELECT "
                + "    curso.ID_CURSO,"
                + "    curso.NOME_CURSO,"
                + "    curso.TIPO_CURSO,"
                + "    (SELECT count(*)"
                + "      FROM TB_ALUNO"
                + "     WHERE ID_CURSO = curso.ID_CURSO) as QTD_ALUNOS"
                + " FROM"
                + "    TB_CURSO as curso"
                + " ORDER BY curso.NOME_CURSO";

        stm = ConnectionFactory.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        ResultSet resultados = stm.executeQuery(query);

        while (resultados.next()) {
            Curso c = new Curso();

            c.setIdCurso(resultados.getInt("ID_CURSO"));
            c.setNomeCurso(resultados.getString("NOME_CURSO"));
            c.setTipoCurso(resultados.getString("TIPO_CURSO"));

            int qtdAlunos = resultados.getInt("QTD_ALUNOS");
            resultado.put(c, qtdAlunos);
        }

        stm.getConnection().close();

        return resultado;
    }

    public boolean deleteCurso(int idCurso) {
        try {
            String query = "DELETE FROM tb_curso WHERE id_curso = ?";
            PreparedStatement stm = ConnectionFactory.getConnection()
                    .prepareCall(query);
            stm.setInt(1, idCurso);
            stm.execute();
            stm.getConnection().close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean insereCurso(Curso curso) {
        try {
            String query = "INSERT INTO tb_curso(nome_curso, tipo_curso) "
                    + "VALUES(?, ?)";
            PreparedStatement stm = ConnectionFactory.getConnection()
                    .prepareCall(query);
            stm.setString(1, curso.getNomeCurso());
            stm.setString(2, curso.getTipoCurso());
            stm.execute();
            stm.getConnection().close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ArrayList<Curso> getTodosCursos() throws SQLException {
        String query = "SELECT curso.ID_CURSO, curso.NOME_CURSO, curso.TIPO_CURSO "
                + "FROM TB_CURSO as curso "
                + "ORDER BY curso.NOME_CURSO";
        ArrayList<Curso> cursos = new ArrayList<>();

        stm = ConnectionFactory.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        
        ResultSet resultados = stm.executeQuery(query);
        
        while(resultados.next()) {
            Curso c = new Curso();
            c.setIdCurso(resultados.getInt("ID_CURSO"));
            c.setNomeCurso(resultados.getString("NOME_CURSO"));
            c.setTipoCurso(resultados.getString("TIPO_CURSO"));
            cursos.add(c);
        }
        
        stm.getConnection().close();
        
        return cursos;
    }
}
