package longobardo.giovanni.HibernateObjectState;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pacco {
	
	@Id
	private int id;
	private String stato;
	
	
	public Pacco() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getStato() {
		return stato;
	}


	public void setStato(String stato) {
		this.stato = stato;
	}


	@Override
	public String toString() {
		return "Pacco [id=" + id + ", stato=" + stato + "]";
	}

	
}
