<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
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
                <form method="post" action="../CursoController"> 

                    <div class="form-group">
                        <label>Nome do Curso:</label>
                        <input type="text" class="form-control" name="nomeCurso" required>
                    </div>

                    <div class="form-group mt-4">
                        <label>Tipo de Curso:</label>
                        <input type="text" class="form-control" name="tipoCurso" required>
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
