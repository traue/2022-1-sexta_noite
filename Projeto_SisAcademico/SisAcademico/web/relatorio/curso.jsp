<%@page import="java.util.Map"%>
<%@page import="br.sisacademico.model.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    Map<Curso, Integer> listaDeCursos = (Map) session.getAttribute("listaDeCursos");
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <jsp:include page="../menu.jsp"></jsp:include>
            <script src="../js/modal_exclusao.js"></script>
            <script>
                $(function () {
                    $('[data-toggle="tooltip"]').tooltip();
                });
            </script>
            <div class="container mt-4">
                <div class="table-responsive-md" style="width: 90; margin: 0 auto;">
                    <table class="table">
                        <thead class="thead-dark">
                        <th>Curso</th>
                        <th>Tipo de Curso</th>
                        <th class="text-center">Qtd. de Alunos</th>
                        <th class="text-center">Ver alunos</th>
                        <th class="text-center">Editar</th>
                        <th class="text-center">Excluir</th>
                        </thead>
                        <tbody>
                        <% for (Map.Entry<Curso, Integer> c : listaDeCursos.entrySet()) {%>
                        <tr>
                            <td><%= c.getKey().getNomeCurso()%></td>
                            <td><%= c.getKey().getTipoCurso()%></td>
                            <td class="text-center"><%= c.getValue()%></td>

                            <% if (c.getValue() == 0) { %>
                            <td class="text-center">
                                <span class="d-inline" data-toggle="tooltip" title="Sem alunos para exibir">
                                    <button class="btn btn-secondary" disabled>Alunos Matriculados</button>
                                </span>
                            </td>
                            <% } else { %>
                            <td class="text-center">
                                <a href="#" class="btn btn-outline-info">Alunos Matriculados</a>
                            </td>
                            <% } %>



                            <td class="text-center"><a class="btn btn-outline-primary" href="#">Editar</a></td>


                            <% if (c.getValue() > 0) { %>
                            <td class="text-center">
                                <span class="d-inline" data-toggle="tooltip" title="Não é possível excluir pois há alunos matriculados">
                                    <button class="btn btn-secondary" disabled>Excluir</button>
                                </span>
                            </td>
                            <% } else { %>
                            <td class="text-center">
                                <a href="../CursoController?acao=EXCLUSAO&idCurso=<%=c.getKey().getIdCurso()%>"  class="btn btn-outline-danger" id="deleteCurso">Excluir</a>
                            </td>
                            <% } %>


                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>

    </body>
</html>
