<%@page import="br.uninove.imc.Imc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    float peso = Float.parseFloat(request.getParameter("peso"));
    float altura = Float.parseFloat(request.getParameter("altura"));
    float resultado = 0;
    
    Imc i = new Imc();
    i.setAltura(altura);
    i.setPeso(peso);
    
    resultado = i.calcularIMC();
%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora IMC</title>
    </head>
    <body>
        <h1>Calculadora IMC - Resultados</h1>
        <hr>
        <br>
        <br>
        <ul>
            <li><b>Peso informado: </b><%=peso%></li>
            <li><b>Altura informada: </b><%=altura%></li>
            <li><b>IMC: </b><%=resultado%></li>
        </ul>
    </body>
</html>
