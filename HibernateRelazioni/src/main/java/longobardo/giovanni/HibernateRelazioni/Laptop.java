package longobardo.giovanni.HibernateRelazioni;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Laptop {

	@Id
	private int id;
	private String nome;
	@ManyToMany(mappedBy="laptop")
	private List<Studente> studente = new ArrayList<Studente>();
	
	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Studente> getStudente() {
		return studente;
	}
	public void setStudente(List<Studente> studente) {
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
