/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Douglas Oliveira
 */
public class Professor extends Pessoa{
    
    private int idProf;
   // private float salario;

    public Professor(String nome, String cpf){
    
    this.setNome(nome);
    this.setCpf(cpf);
    
    
    }
    public Professor(){
    
    }
    

    public int getIdProf() {
        return idProf;
    }

    /**
     * @param idProf the idProf to set
     */
    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public float getSalario() {
        return salario;
   }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    
    
    
    
    
    
    
    
    
    
}
