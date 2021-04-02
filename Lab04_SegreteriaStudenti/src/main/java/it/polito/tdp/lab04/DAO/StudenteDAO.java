package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Studente getStudenteDaMatricola(int matricola) {
		String sql="SELECT * "
				+ "FROM studente "
				+ "WHERE matricola=?";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				Studente s=new Studente(rs.getInt("matricola"),rs.getString("nome"),rs.getString("cognome"),rs.getString("CDS"));
				rs.close();
				st.close();
				conn.close();
				return s;
			}
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return null;
	}
	
	
	public List<Corso> corsiPerMatricola(Integer matricola){
		String sql="SELECT c.codins, c.crediti, c.nome, c.pd "
				+ "FROM iscrizione AS i, corso AS c "
				+ "WHERE i.codins=c.codins AND i.matricola=?";
		List<Corso> corsi =new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Corso c=new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				corsi.add(c);
			}
			rs.close();
			st.close();
			conn.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return corsi;
	}
}
