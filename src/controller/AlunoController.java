/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Aluno;
import model.AlunoDao;
import model.Aula;
import model.AulaDao;

/**
 *
 * @author Douglas Oliveira
 */
public class AlunoController {
    
    private AlunoDao alunoDao;
	
	public AlunoController() {
		this.alunoDao = new AlunoDao();
	}
	
	public boolean cadastrar(Aluno aluno) {
		boolean resultado = false;
		try {
			resultado = this.alunoDao.inserir(aluno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}


}
