<%@page import="br.sisacademico.model.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Aluno> alunos = null;
    
    if(session.getAttribute("listaDeAlunos") != null) {
        alunos = (ArrayList)session.getAttribute("listaDeAlunos");
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="../menu.jsp"></jsp:include>
        
        <% if(alunos != null) { %>
        <div class="container mt-4">
            <div class="table-responsive-md" style="width: 90; margin: 0 auto;">
                <table class="table">
                    <thead class="thead-dark">
                    <th>RA</th>
                    <th>Nome do Alunos</th>
                    <th>Curso</th>
                    <th>Tipo de Curso</th>
                    <th class="text-center">Editar</th>
                    <th class="text-center">Excluir</th>
                    </thead>
                    <tbody>
                        <% for(Aluno a : alunos) { %>
                        <tr>
                            <td><%= a.getRa() %></td>
                            <td><%= a.getNome() %></td>
                            <td><%= a.getCurso().getNomeCurso() %></td>
                            <td><%= a.getCurso().getTipoCurso() %></td>
                            <td class="text-center"><a class="btn btn-outline-primary" href="#">Editar</a></td>
                            <td class="text-center"><a class="btn btn-outline-danger" href="#">Excluir</a></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>    
            </div>
        </div>
        <% } else { %>
        
        <% } %>
    </body>
</html>
