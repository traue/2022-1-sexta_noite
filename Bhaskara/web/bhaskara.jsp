<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    double a, b, c;
    a = Double.parseDouble(request.getParameter("valorA"));
    b = Double.parseDouble(request.getParameter("valorB"));
    c = Double.parseDouble(request.getParameter("valorC"));
%>

<jsp:useBean id="bhaskara" scope="page" class="br.uninove.Bhaskara"></jsp:useBean>

<jsp:setProperty name="bhaskara" property="a" 
value="<%=a%>"></jsp:setProperty>

<jsp:setProperty name="bhaskara" property="b" 
value="<%=b%>"></jsp:setProperty>

<jsp:setProperty name="bhaskara" property="c" 
value="<%=c%>"></jsp:setProperty>

<%
    bhaskara.calculaDelta();
    bhaskara.calculaRaizes();

    boolean erro = false;
    String msgErro = "";

    if (bhaskara.getDelta() < 0) {
        erro = true;
        msgErro = "Ops, o delta deu negativo (" + bhaskara.getDelta() + ")";
    }

    if (bhaskara.getA() == 0) {
        erro = true;
        msgErro = "Ops, o valor \"a\" não pode ser zero!";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bhaskara - Resultados</title>
        <style>
            .resultados {
                margin-left: 40px;
                font-size: 24px;
            }
        </style>
    </head>
    <body>
        <h1>Resolução de Equações Quadrádicas por Bhaskara</h1>
        <hr>
        <br>
        <div class="resultados">
            <h2>A resolução da equação:</h2>
            <p><%=a%>x² + <%=b%>x + <%=c%> = 0</p>
            <% if (erro) { %>
                <h3>Ops... algo deu errado:</h3>
                <p><%=msgErro%></p>
            <% } else {%>
                <ul>
                    <li><b>Delta: </b><%=bhaskara.getDelta()%></li>
                    <li><b>X': </b><%=bhaskara.getrP()%></li>
                    <li><b>X'': </b><%=bhaskara.getrN()%></li>
                </ul>
            <% }%>
            <a href="./">Calcular novamente...</a>
        </div>
    </body>
</html>
