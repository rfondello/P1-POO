/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author angelo
 */
public class Disciplina {
    
    private String nome;
    private String ementa;
    private String ciclo;
    private String nota;

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
    
    private static ArrayList<Disciplina> disciplina;
    
    public static ArrayList<Disciplina> getDisciplinas(){
        if(disciplina == null){
            disciplina = new ArrayList<>();
            Disciplina d = new Disciplina();
            d.setNome("Lab. de Banco de Dados");
            d.setEmenta("Aprendemos a sentar nos dados");
            d.setCiclo("5");
            d.setNota("10");

            disciplina.add(d);
        }
        return disciplina;
    }
    
}
