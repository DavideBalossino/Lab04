package it.polito.tdp.lab04.model;

public class Corso {
	String codins;
	Integer crediti;
	String nome;
	Integer periodo;
	
	public Corso(String codins, Integer crediti, String nome, Integer periodo) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.periodo = periodo;
	}

	public String getCodins() {
		return codins;
	}

	public int getCrediti() {
		return crediti;
	}

	public String getNome() {
		return nome;
	}

	public int getPeriodo() {
		return periodo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome;
	}
	
	
	

}
