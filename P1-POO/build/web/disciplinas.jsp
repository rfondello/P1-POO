<%-- 
    Document   : disciplinas
    Created on : 1 de out de 2020, 13:05:46
    Author     : Rgrigo Fondello
--%>

<%@page import="Classes.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String exceptionMessage = null;
    
        if(request.getParameter("delete")!=null){
            try{
                String nome = request.getParameter("nome");
                Disciplina.delete(nome);
                response.sendRedirect(request.getRequestURI());
                
                
            }catch(Exception  ex){
               exceptionMessage = ex.getLocalizedMessage(); 
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
        
                <table border="1"> 
            <tr>
                <th>Nome Disciplina</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th>Comandos</th>
            <tr>
                <%for (Disciplina disciplina: Disciplina.getDisciplina()) {%>
            </tr>
            <td><%= disciplina.getNome()%></td>
            <td><%= disciplina.getEmenta()%></td>
            <td><%= disciplina.getCiclo()%></td>
            <td><%= disciplina.getNota()%></td>

            <td>
                <%int i = disciplina.getDisciplina().indexOf(disciplina);%>
                <a href="alterar.jsp?i=<%=i%>">Alterar</a>
            </td>
            <td>
                <%(request.getParameter("delete")!=null);%>
                <input type="submit" name ="delete" value="Excluir"/>
            </td>
            
            </tr>
            <%}%>
        </table>
        
    </body>
</html>
