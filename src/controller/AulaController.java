/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Aula;
import model.AulaDao;

/**
 *
 * @author Douglas Oliveira
 */
public class AulaController {
    
    private AulaDao aulaDao;
	
	public AulaController() {
		this.aulaDao = new AulaDao();
	}
	
	public boolean cadastrar(Aula aula) {
		boolean resultado = false;
		try {
			resultado = this.aulaDao.inserir(aula);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}


	


	
}
