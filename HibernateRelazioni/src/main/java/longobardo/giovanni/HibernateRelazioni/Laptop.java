package longobardo.giovanni.HibernateRelazioni;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Laptop {

	@Id
	private int id;
	private String nome;
	private Studente studente;
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Studente getStudente() {
		return studente;
	}
	public void setStudente(Studente studente) {
		this.studente = studente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", nome=" + nome + "]";
	}
	
	
}
