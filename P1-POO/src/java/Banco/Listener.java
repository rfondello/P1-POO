/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import Classes.Disciplina;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.catalina.Manager;


/**
 * Web application lifecycle listener.
 *
 * @author pc
 */
public class Listener implements ServletContextListener {
    
    public static final String jdbcUrl = "jdbc:sqlite:\\home\\pc\\POO-P1-POO";

    public static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try{
            Class.forName("org.sqlite.JDBC");
            Connection c = DriverManager.getConnection(jdbcUrl);
            Statement stmt = c.createStatement();
            
            String sql;
            
            sql = "CREATE TABLE IF NOT EXISTS disciplinas("
                    + "nome varchar(100),"
                    + "ementa varchar(100),"
                    + "ciclo varchar(10),"
                    + "nota varchar(3));";
            stmt.executeUpdate(sql);
            
           if(Disciplina.getDisciplina().isEmpty()){
               sql = "INSERT INTO disciplinas VALUES ('Banco de dados', 'Ementa', '5º ciclo', 10);";
               stmt.executeUpdate(sql);
           } 
            
        }catch (ClassNotFoundException ex){
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            
        } catch (SQLException ex) {
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
        }
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
