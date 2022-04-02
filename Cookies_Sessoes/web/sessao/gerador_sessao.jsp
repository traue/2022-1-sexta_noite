<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dados guardados - Sessão</title>
    </head>
    <body>
        <h1>Dados guardados na sessão....</h1>
        <hr>
        <%
            String nome = request.getParameter("nome");
            int idade = Integer.parseInt(request.getParameter("idade"));
            

            session.setAttribute("nomeUsuario", nome);
            session.setAttribute("idadeUSuario", idade);
            
        %>
        <br>
        <a href="./">Voltar para a raíz do projeto de sessões</a>
    </body>
</html>
