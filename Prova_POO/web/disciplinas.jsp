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
        String exceptionMessage = null;
        if(request.getParameter("FormInsert")!=null){
            try{
            String nome = request.getParameter("nome");
            String ementa = request.getParameter("ementa");
            int ciclo = Integer.parseInt(request.getParameter("ciclo"));
            Double nota = Double.parseDouble(request.getParameter("nota"));
            Disciplina.insert(nome, ementa, ciclo, nota);
            response.sendRedirect(request.getRequestURI());
            }catch(Exception ex){
                exceptionMessage = ex.getLocalizedMessage();
            }
        }
         if(request.getParameter("FormUpdate")!=null){
            try{
            long rowlid =  Long.parseLong(request.getParameter("rowlid"));
            String nome = request.getParameter("nome");
            String ementa = request.getParameter("ementa");
            int ciclo = Integer.parseInt(request.getParameter("ciclo"));
            Double nota = Double.parseDouble(request.getParameter("nota"));
            Disciplina.insert(nome, ementa, ciclo, nota);
            response.sendRedirect(request.getRequestURI());
            }catch(Exception ex){
                exceptionMessage = ex.getLocalizedMessage();
            }
        }
          if(request.getParameter("FormDelete")!=null){
            try{
            long rowlid =  Long.parseLong(request.getParameter("rowlid"));
            Disciplina.delete(rowlid);
            response.sendRedirect(request.getRequestURI());
            }catch(Exception ex){
                exceptionMessage = ex.getLocalizedMessage();
            }
        }
        %> 
        
        <%@include file="WEB-INF/jspf/menu.jspf"%>
        <h1>Disciplinas</h1>
        <%if(request.getParameter("prepararInsert")!=null){%>
        <h3>Incluir Disciplina</h3>
        <form>
            Nome:<input type="text" name="nome">
            Ementa:<input type="text" name="ementa">
            Ciclo:<input type="text" name="ciclo">
            Nota:<input type="text" name="nota">
            
            <input type="submit" name="FormInsert" value="Inserir"/>
            <input type="submit" name="Cancelar" value="Canselar"/>
        </form>
        <%}else if(request.getParameter("prepararUpdate")!= null){%>
        <h3>Alterar Disciplina</h3>
        <form>
            <%
            String rowlid = request.getParameter("rowlid");
            String nome = request.getParameter("nome");
            String ementa = request.getParameter("ementa");
            String ciclo = request.getParameter("ciclo");
            String nota = request.getParameter("nota");
            %>
            <input type="hidden" name="rowlid" value="<%=rowlid%>"/>
            Nome:<input type="text" name="nome" value="<%=nome%>"/>
            Ementa:<input type="text" name="ementa" value="<%=ementa%>"/>
            Ciclo:<input type="text" name="ciclo" value="<%=ciclo%>"/>
            Nota:<input type="text" name="nota" value="<%=nota%>"/>
            
            <input type="submit" name="FormUpdate" value="Alterar"/>
            <input type="submit" name="Cancelar" value="Canselar"/>
        </form>
        <%}else if(request.getParameter("prepararDelete")!=null){%>
        <h3>Excluir Disciplina</h3>
        <form>
            <%String rowlid = request.getParameter("rowlid");%>
            <input type="hidden" name="rowlid" value="<%=rowlid%>"/>
            Excluir a disciplina <b><%=rowlid%><b>?
            <input type="submit" name="FormDelete" value="Deletar"/>
            <input type="submit" name="Cancelar" value="Canselar"/>
        </form>
        <%}else{%>
        <form method="post">
            <input type="submit" name="prepararInsert" value="Inserir"/>
        </form>
        <%}%>
        <h3>Lista de Disciplinas</h3>
        <table border="1">
            <tr>
                <th>Indice</th>
                <th>Disciplina</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
            </tr>
            <%for(Disciplina d: Disciplina.getList()){%>
            <tr>
                <th><%=d.getRowlid()%></th>
                <th><%=d.getNome()%></th>
                <th><%=d.getEmenta()%></th>
                <th><%=d.getCiclo()%></th>
                <th><%=d.getNota()%></th>
            </tr>
            <th>
            <form>
                 <input type="hidden" name="rowlid" value="<%=d.getRowlid()%>"/>
                  <input type="hidden" name="nome" value="<%=d.getNome()%>"/>
                   <input type="hidden" name="ementa" value="<%=d.getEmenta()%>"/>
                    <input type="hidden" name="cilco" value="<%=d.getCiclo()%>"/>
                     <input type="hidden" name="nota" value="<%=d.getNota()%>"/>
            </form>
            </th>
            <%}%>
        </table>
        <%@include file="WEB-INF/jspf/menu.jspf"%>
    </body>
</html>
