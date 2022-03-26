<%@page import="java.net.URLDecoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendo as Cookies Geradas</title>
    </head>
    <body>
        <h1>Vendo as Cookies Geradas</h1>
        <hr>
        <br>
        <br>
        <%
            String nomeCookie = "nomeUsuario";
            String idadeCookie = "idadeUsuario";

            Cookie cookieNomeUsuario = null;
            Cookie cookieIdadeUsuario = null;
            Cookie listaCookies[] = request.getCookies();

            if (listaCookies != null) {
                //loop para busca do cookie do nome:
                for (int i = 0; i < listaCookies.length; i++) {
                    if (listaCookies[i].getName().equals(nomeCookie)) {
                        cookieNomeUsuario = listaCookies[i];
                        break;
                    }
                }

                //loop para busca do cookie da idade
                for (int i = 0; i < listaCookies.length; i++) {
                    if (listaCookies[i].getName().equals(idadeCookie)) {
                        cookieIdadeUsuario = listaCookies[i];
                        break;
                    }
                }
            }
        %>

        <% if (cookieNomeUsuario != null) {%>
        <p>
            <b>Nome do usuário encontrado na cookie: </b>
            <%= URLDecoder.decode(cookieNomeUsuario.getValue(), "UTF-8")%>
        </p>
        <% } else { %>
        <p>
            <b>Cookie do nome não encontrada!</b>
        </p>
        <% }%>
        <br>
        <% if (cookieIdadeUsuario != null) {%>
        <p>
            <b>Idade do usuário encontrada: </b>
            <%= URLDecoder.decode(cookieIdadeUsuario.getValue(), "UTF-8")%>
        </p>
        <% } else { %>
        <p>
            <b>Cookie da idade não encontrada!</b>
        </p>
        <% }%>
        
        <br><br>
        <a href="./">Voltar para a raíz do projeto de cookies</a>
    </body>
</html>
