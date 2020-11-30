/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import web.DbListener;

/**
 *
 * @author Rodrigo Alves Fondello
 */
public class Disciplina {
    long rowlid;
    String nome;
    String ementa;
    int ciclo;
    double nota;
    
    public Disciplina(long rowlid, String nome, String ementa, int ciclo, double nota){
    this.rowlid = rowlid;
    this.nome = nome;
    this.ementa = ementa;
    this.ciclo = ciclo;
    this.nota = nota;
    }
    
    public static ArrayList<Disciplina>getList()throws Exception{
    ArrayList<Disciplina> list = new ArrayList <>();
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    Exception metohodException = null;
    
    try{
    con = DbListener.getConnection();
    stmt = con.createStatement();
    rs = stmt.executeQuery("SELECT rowlid, * FROM disciplinas");
    while(rs.next()){
    list.add(new Disciplina(
    rs.getLong("rowlid"),
    rs.getString("nome"),
    rs.getString("ementa"),
    rs.getInt("ciclo"),
    rs.getDouble("nota")
    ));
    }
        catch(Exception ex){
         methodException = ex;   
        }
        finally{
        try{rs.close();}catch(Exception ex2){};
        try{stmt.close();}catch(Exception ex2){};
        try{con.close();}catch(Exception ex2){};
        }
        if(methodException != null) throw methodException;
        return list;
    }
    }
    
        
    public static void insert(String nome, String ementa, int ciclo, double nota) throws Exception{
    
    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Exception methodException = null;
    try{
    
    con = DbListener.getConnection();
    stmt = con.prepareStatement("INSERT INTO disciplinas VALUES(?,?,?,?)");
    stmt.setString(1, nome);
    stmt.setString(2, ementa);
    stmt.setInt(3, ciclo);
    stmt.setDouble(4, nota);
    stmt.execute();
    
    }catch(Exception ex){
    methodException = ex;
    }finally{
       try{rs.close();}catch(Exception ex2){};
       try{stmt.close();}catch(Exception ex2){};
       try{con.close();}catch(Exception ex2){};   
    }
    if(methodException != null) throw methodException;
    }
    
    public static void update(long rowlid, String nome, String ementa, int ciclo, double nota) throws Exception {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Exception methodException = null;
        try{
    
    con = DbListener.getConnection();
    stmt = con.prepareStatement("UPDATE disciplinas SET nome=?, ementa=?, ciclo=?, nota=?  "
    +"WHERE rowlid=?");
    stmt.setString(1, nome);
    stmt.setString(2, ementa);
    stmt.setInt(3, ciclo);
    stmt.setDouble(4, nota);
    stmt.execute();
    
    }catch(Exception ex){
    methodException = ex;
    }finally{
       try{rs.close();}catch(Exception ex2){};
       try{stmt.close();}catch(Exception ex2){};
       try{con.close();}catch(Exception ex2){};   
    }
    if(methodException != null) throw methodException;
    }
   
    public static void delete(long rowlid) throws Exception{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Exception methodException = null;
         try{
    
    con = DbListener.getConnection();
    stmt = con.prepareStatement("DELETE FROM disciplinas WHERE rowlid=?");
    stmt.setLong(1, rowlid);
    stmt.execute();
    
    }catch(Exception ex){
    methodException = ex;
    }finally{
       try{rs.close();}catch(Exception ex2){};
       try{stmt.close();}catch(Exception ex2){};
       try{con.close();}catch(Exception ex2){};   
    }
    if(methodException != null) throw methodException;
    }
    
    
    public long getRowlid() {
        return rowlid;
    }

    public void setRowlid(long rowlid) {
        this.rowlid = rowlid;
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

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    
    
    }
    

