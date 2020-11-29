<%-- 
    Document   : disciplinas
    Created on : 3 de out de 2020, 18:16:04
    Author     : Rodrigo ALves Fondello
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
       
        <%
        if(request.getParameter("salvar")!= null){
         int codigo = Integer.parseInt(request.getParameter("codigo"));
         int nota = Integer.parseInt(request.getParameter("nota"));
         Disciplina disciplina = Disciplina.getDisciplina().get(codigo);
         disciplina.setNota(nota);
        }
        %> 
        
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        <h1>Disciplinas</h1>
        
        <table border ="1">
    <tr>
        <th>Nome Disciplina</th>
        <th>Ementa</th>
        <th>Ciclo</th>
        <th>Nota</th>
        <th>Comandos</th>
    </tr>  
    <tr>
    <% for (int i = 0; i <Disciplina.getDisciplina().size(); i++){
        Disciplina disciplina = (Disciplina)Disciplina.getDisciplina().get(i);%>
        <td><%= disciplina.getNome()%></td>
        <td><%= disciplina.getEmenta()%></td>
        <td><%= disciplina.getCiclo()%></td>
        <td><%= disciplina.getNota()%></td>
    
        <td>
            <form metohod="get">
                <input type ="text" name="nota" value="0"/>
                <input type ="submit"  value="Salvar"/>
                <input type ="hidden"  value="salvar" value ="1"/>
                <input type ="hidden" name="codigo" value="<%=i%>"/>
            </form>
            
        </td>
    </tr>
    
    
        <%}%>
        </table>
    
    </body>
</html>
