package br.sisacademico.dao;

import br.sisacademico.model.Curso;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}
