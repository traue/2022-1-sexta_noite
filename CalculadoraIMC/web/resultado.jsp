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
        <table border="1px" style="text-align: center;">
            <thead>
                <th>Dado</th>
                <th>Resultado</th>
            </thead>
            <tbody>
                <tr>
                    <td><b>Peso informado: </b></td>
                    <td><%= String.format("%.2f", peso)%></td>
                </tr>
                <tr>
                    <td><b>Altura informada: </b></td>
                    <td><%= String.format("%.2f", altura)%></td>
                </tr>
                <tr>
                    <td><b>IMC:</b> </td>
                    <td><%= String.format("%.2f", resultado)%></td>
                </tr>
                <tr>
                    <td><b>Classificação: </b></td>
                    <td><%= i.calculaClassificacao(resultado)%></td>
                </tr>
                
            </tbody>
    </table>
    <br>
    <b>OU...</b>
    <ul>
        <li><b>Peso informado: </b><%= String.format("%.2f", peso)%></li>
        <li><b>Altura informada: </b><%= String.format("%.2f", altura)%></li>
        <li><b>IMC: </b><%= String.format("%.2f", resultado)%></li>
        <li><b>Classificação: </b><%=i.calculaClassificacao(resultado)%></li>
    </ul>
    <br>
    <a href="./">Voltar...</a>
</body>
</html>
