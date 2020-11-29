<%-- 
    Document   : alterar
    Created on : 1 de out de 2020, 13:29:34
    Author     : Rodrigo Fondello
--%>

<%@page import="Classes.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String error = null;
    Disciplina disc = null;
    int i = -1;
    if(request.getParameter("i") != null){
        i = Integer.parseInt(request.getParameter("i"));
        disc = Disciplina.getDisciplinas().get(i);
        if(disc == null){
            error = "Índice inválido!";
        }
    }
    if ( request.getParameter("edit") != null){
        String nome = request.getParameter("nome");
        String ementa = request.getParameter("ementa");
        String ciclo = request.getParameter("ciclo");
        String nota = request.getParameter("nota");
        if (nome.isEmpty()) 
        {
            error = "Nome de disciplina invaloda";
        }else if ( ementa.isEmpty())
        {
            error = "Ementa não descrita";
        }
        else if (ciclo.isEmpty())
        {
            error = "Ciclo invalido";
        }
        else
        {
            if (nota.isEmpty())
            {
                Disciplina editDisc = new Disciplina();
                editDisc.setNota(nota);
                Disciplina.getDisciplinas().set(i, editDisc); 
                response.sendRedirect("disciplinas.jsp");
            } 
            else 
            {
                error = "Nota invalida";
            }
        } 
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf"%> 
        <h1>Disciplinas</h1>
        
        <% if (error != null ){ %>
        <div style="color: red"><%= error %> </div>       
        <% } else { %>
        <form method="post">
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
            <td><input type="text" name="nota" value="<%=disciplina.getNota()%>"/><br/></td>
            <td><input type="submit" name="edit" value="Salvar"/><br/></td>
            <%}%>
        <%}%>
           
        </table>
        </form>
    </body>
</html>
