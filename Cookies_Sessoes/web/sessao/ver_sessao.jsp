<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sessão - Vendo os dados</title>
    </head>
    <body>
        <h1>Vendo os dados guardados na Sessão</h1>
        <hr>
        <br>
        <br>
        <%

            String nome = "{sem dados para exibir}";
            int idade = -1;

            if ((String)session.getAttribute("nomeUsuario") != null) {
                nome = (String) session.getAttribute("nomeUsuario");
            }

            if (session.getAttribute("idadeUsuario") != null) {
                idade = (int) session.getAttribute("idadeUSuario");
            }

        %>
        <h3>Dados guardados na sessão:</h3>
        <p><b>Nome do usuário: </b><%=nome%></p>
        <p><b>Idade do usuário: </b><%=idade%></p>
    </body>
</html>
