/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Aluno;
import model.AlunoDao;
import model.Professor;
import model.ProfessorDao;

/**
 *
 * @author Douglas Oliveira
 */
public class ProfessorController {
    
    
     private ProfessorDao professorDao;
	
	public ProfessorController() {
		this.professorDao = new ProfessorDao();
	}
	
	public boolean cadastrar(Professor professor) {
		boolean resultado = false;
		try {
			resultado = this.professorDao.inserir(professor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	


    
    
    
    
}
