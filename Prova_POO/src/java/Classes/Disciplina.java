/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;

/**
 *
 * @author Rodrigo Alves Fondello
 */
public class Disciplina {
    String nome;
    String ementa;
    String ciclo;
    
    int nota;

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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    private static ArrayList<Disciplina> disciplina;
    
    public Disciplina(String nome, String ementa, String ciclo){
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
    }
      
    public static ArrayList<Disciplina> getDisciplina(){
        if (disciplina == null){
        disciplina = new ArrayList<>();    
            
        disciplina.add(new Disciplina("Laboratório de Banco de Dados", "Ementa LBD", "5° Ciclo"));
	disciplina.add(new Disciplina("Laboratório de Engenharia de Software", "Ementa LES", "5° Ciclo"));
	disciplina.add(new Disciplina("Gestão de Projetos", "Ementa GP", "5° Ciclo"));
        disciplina.add(new Disciplina("Redes", "Ementa Redes", "5° Ciclo"));
	disciplina.add(new Disciplina("Segurança da Informação", "Ementa SI", "5° Ciclo"));
	disciplina.add(new Disciplina("Inglês V", "Ementa Inglês V", "5° Ciclo"));
	disciplina.add(new Disciplina("Trabalho de Graduação 1", "Ementa TG1", "5° Ciclo"));
	disciplina.add(new Disciplina("Programação Orientada a Objetos", "Ementa POO", "4° Ciclo"));
	disciplina.add(new Disciplina("Programação para dispositivos moveis", "Ementa PDM", "5° Ciclo")); 
        }
        return disciplina;
        }
    
    public ArrayList<Disciplina> getDisciplinas(){
    return disciplina;
    }
    }
    

