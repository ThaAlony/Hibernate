package longobardo.giovanni.HibernateRelazioni;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Studente {
	
	@Id
	private int id;
	private String nome;
	@OneToOne      // BISOGNA INSERRIE UNA ANNOTAZIONE PER DEFINIRE IL TIPO DI RELAZIONE
	private Laptop laptop;

	public Studente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
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
