<%@page import="br.sisacademico.model.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    ArrayList<Curso> cursos = (ArrayList) session.getAttribute("listaCursos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="../menu.jsp"></jsp:include>
            <div class="container mt-4 pt-4">
                <div style="width: 30%; margin: 0 auto;">
                    <form method="post" action="../AlunoController"> 

                        <div class="form-group">
                            <label>RA:</label>
                            <input type="number" class="form-control" name="ra" required>
                        </div>

                        <div class="form-group mt-4">
                            <label>Nome do Aluno:</label>
                            <input type="text" class="form-control" name="nome" required>
                        </div>

                        <div class="form-group mt-4">
                            <label>Curso:</label>
                            <select class="form-control" name="idCurso">
                            <% for (Curso c : cursos) {%>
                            <option value="<%=c.getIdCurso()%>"><%= c.getNomeCurso() + "(" + c.getTipoCurso() + ")"%></option>
                            <%}%>
                        </select>
                    </div>

                    <div class="form-group mt-4">
                        <input type="submit" class="btn btn-primary btn-md w-100" value="Cadastrar">
                    </div>

                    <input type="hidden" name="acao" value="CADASTRO">

                </form>
            </div>
        </div>
    </body>
</html>
