package longobardo.giovanni.HibernateRelazioni;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Studente {
	
	@Id
	private int id;
	private String nome;
	@ManyToMany    // (fetch=FetchType.EAGER = imposta il fetch type di qyesto attributo in EAGER, cioe verrà sempre incluso nella SELECT anche se non richiesto dal codice
	private List<Laptop> laptop = new ArrayList<Laptop>();

	public Studente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
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
		return "Studente [id=" + id + ", nome=" + nome + "]";
	}
	
}
