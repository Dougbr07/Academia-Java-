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
abstract class ClassAbstract {
  
    
    protected float salario;
    protected float pagamento;
    
    public double getBonificacao() {
    return this.salario * 0.10;
    }
     
    // não implementado, projeto para quando tiver tabelas de pagamento.
    public double getDesconto() {
    return this.pagamento * 0.10;
    }
     

    
}
