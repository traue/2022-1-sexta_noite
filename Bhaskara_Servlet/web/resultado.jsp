<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String a, b, c, delta, xp, xn;
    boolean mostraRaizes = false;
    a = request.getParameter("a");
    b = request.getParameter("b");
    c = request.getParameter("c");
    delta = request.getParameter("delta");
    xp = "";
    xn = "";
    if(request.getParameter("xp") != null) {
        xp = request.getParameter("xp");
        xn = request.getParameter("xn");
        mostraRaizes = true;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bhaskara - Resultados</title>
        <link rel="stylesheet" href="css/estilo.css">
    </head>
    <body>
        <h1>Bhaskara - Resultados</h1>
        <hr>
        <h3>Dada a equação <%=a%>x² + <%=b%>x + <%=c%> = 0, temos:</h3>
        <ul>
            <li>Delta = <%=delta%></li>
            <% if(mostraRaizes) { %>
            <li>X' = <%=xp%></li>
            <li>X" = <%=xn%></li>
            <% } else { %>
            <li>Não existem raízes reais para essa equação</li>
            <% } %>
        </ul>
        <a href="./">Calcular novamente</a>
    </body>
</html>
