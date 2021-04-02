package it.polito.tdp.lab04.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	CorsoDAO corsoDao;
	StudenteDAO studenteDao;

	public Model(){
		corsoDao=new CorsoDAO();
		studenteDao=new StudenteDAO();
	}
	public List<Corso> elencoCorsi(){
		return corsoDao.getTuttiICorsi();
	}
	
	public Studente getNomeDaMatricola(int matricola) {
		return studenteDao.getStudenteDaMatricola(matricola);
	}
	
	public List<Studente> studentiIscrittiCorso(Corso c){
		return corsoDao.getStudentiIscrittiAlCorso(c);
	}
	
	public List<Corso> corsiMatricolaIscritta(Integer matricola){
		return studenteDao.corsiPerMatricola(matricola);
	}
	
	public boolean iscriviStudenteAlCorso(Studente s, Corso c) {
		return corsoDao.inscriviStudenteACorso(s, c);
	}
}
