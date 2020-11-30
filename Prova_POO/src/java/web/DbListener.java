/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Classes.Disciplina;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;

/**
 * Web application lifecycle listener.
 *
 * @author Rodrigo ALves Fondello
 */
public class DbListener implements ServletContextListener {

    private static final String CLASS_NAME = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:banco";
    private static String exceptionMessage = null; 
    
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(DB_URL);
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String etapa = "Conexão inicializada";
        Connection con = null;
        Statement stmt = null;
        try{
        etapa = "Iniciando";
        con = getConnection();
        etapa = "Preparando statement";
        stmt = con.createStatement();
        etapa = "Criar tabela Disciplinas";
        stmt.execute(Disciplina.getCreateStatement());
        if(Disciplina.getList().isEmpty()){
        
            etapa = "Criar primeiro registro";
            stmt.execute("INSERT INTO disciplinas VALUES("
            + "Lab. Banco de Dados,"
            + "Ementa BD,"
            + "5,"
            + "8,"
            +")");      
        }
        etapa = "Desconectando do banco";
        }
        catch(Exception ex){
        exceptionMessage = etapa +":"+ ex.getLocalizedMessage();
        }
        finally{
        try{stmt.close();}catch(Exception ex2){};
        try{con.close();}catch(Exception ex2){};
        }
        
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
