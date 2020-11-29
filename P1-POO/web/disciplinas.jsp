<%-- 
    Document   : disciplinas
    Created on : 1 de out de 2020, 13:05:46
    Author     : Rgrigo Fondello
--%>

<%@page import="Classes.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf"%> 
        <h1>Disciplinas</h1>
        
                <table border="1"> 
            <tr>
                <th>Nome Disciplina</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th>Comandos</th>
            <tr>
                <%for (Disciplina disciplina: Disciplina.getDisciplinas()) {%>
            </tr>
            <td><%= disciplina.getNome()%></td>
            <td><%= disciplina.getEmenta()%></td>
            <td><%= disciplina.getCiclo()%></td>
            <td><%= disciplina.getNota()%></td>

            <td>
                <%int i = disciplina.getDisciplinas().indexOf(disciplina);%>
                <a href="alterar.jsp?i=<%=i%>">Alterar</a>
            </td>
            
            </tr>
            <%}%>
        </table>
        
    </body>
</html>
