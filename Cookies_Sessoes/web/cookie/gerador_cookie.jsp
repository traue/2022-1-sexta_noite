<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cookie gerada!</title>
    </head>
    <body>
        <h1>Cookie gerada....</h1>
        <hr>
        <%
            String nome = request.getParameter("nome");
            int idade = Integer.parseInt(request.getParameter("idade"));

            if (nome == null) {
                nome = "";
            }

            String nomeCodificado = URLEncoder.encode(nome, "UTF-8");
            String idadeCodificada
                    = URLEncoder.encode(String.valueOf(idade), "UTF-8");

            Cookie cookieNome = new Cookie("nomeUsuario", nomeCodificado);
            Cookie cookieIdade = new Cookie("idadeUsuario", idadeCodificada);
            
            cookieNome.setMaxAge(120); //em segundos
            cookieIdade.setMaxAge(120);
            
            response.addCookie(cookieNome);
            response.addCookie(cookieIdade);
        %>
        
        <br>
        <a href="./">Voltar para a raíz do projeto de cookeis</a>
    </body>
</html>
