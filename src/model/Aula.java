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
public class Aula {
    
    private String nome;
    private int idAula;
    private int idProf;
    private String nomeProf;
    private String horario;
    private float preco;

public Aula(String nome,float preco){
    this.nome = nome;
    this.preco = preco;
}

 public Aula(){
     
}   
    
    
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the idAula
     */
    public int getIdAula() {
        return idAula;
    }

    /**
     * @param idAula the idAula to set
     */
    public void setIdAula(int idAula) {
        this.idAula = idAula;
    }

    /**
     * @return the idProf
     */
    public int getIdProf() {
        return idProf;
    }

    /**
     * @param idProf the idProf to set
     */
    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    /**
     * @return the nomeProf
     */
    public String getNomeProf() {
        return nomeProf;
    }

    /**
     * @param nomeProf the nomeProf to set
     */
    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
    
    
    
    
    
    
    
    
    
}
