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
public class Aluno extends Pessoa implements InterfaceAluno{
    


   private float altura;
   private int idade;
   private int idAluno;
   private int peso;


   public Aluno(String nome, String cpf) {

       this.setNome(nome);
       this.setCpf(cpf);

}
   
   public Aluno(){
   
   
   
   }
   
   
    public float getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the idAluno
     */
    public int getIdAluno() {
        return idAluno;
    }

    /**
     * @param idAluno the idAluno to set
     */
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
   public void setPeso(int peso) {
        this.peso = peso;
    }

    @Override
    public float verificarImc(float altura, float peso) {
       
        float resultado = 0;
        
        resultado = peso / (altura * altura);
       
       
       return resultado;
    }


    
    
    
    
    
    
    
}
