/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Banco.Listener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Rodrigo Fondello
 */
public class Disciplina {

    
    
    private String nome;
    private String ementa;
    private String ciclo;
    private String nota;
    
    public Disciplina(String nome, String ementa, String ciclo, String nota){
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
        this.nota = nota;
    }
    
    public static ArrayList<Disciplina> getDisciplina() throws SQLException{
        ArrayList<Disciplina> list = new ArrayList<>();
        
        Connection c = DriverManager.getConnection(Listener.jdbcUrl);
        Statement stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM disciplinas");
        
        while(rs.next()){
            list.add(
                    new Disciplina(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4))
                    );
            
        }
        
        rs.close();
        stmt.close();
        c.close();
        return list;
    }
    
    public static void changeNota(String nome, String nota) throws SQLException{
        Connection c = DriverManager.getConnection(Listener.jdbcUrl);
        PreparedStatement stmt = c.prepareStatement("UPDATE disciplinas SET nota = ? WHERE nome = ?");
        stmt.setString(1, nota);
        stmt.setString(2, nome);
        
        stmt.execute();
        
        stmt.close();
        c.close();
    }       
    
    public static void delete(String nome) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Exception methodException = null;
        try{
            con = Listener.getConnection();
            stmt = con.prepareStatement("DELETE FROM disciplinas WHERE nome=?");
            stmt.setString(1, nome);
            stmt.execute();
        }catch(Exception ex){
            methodException = ex;
        }finally{
            try{rs.close();}catch(Exception ex2){}
            try{stmt.close();}catch(Exception ex2){}
            try{con.close();}catch(Exception ex2){}
        }
        if(methodException != null) throw methodException;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
}
