package longobardo.giovanni.HbernateQueryLanguage;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Ninja {
	
	@Id
	private int id;
	private String nome;
	private String villaggio;
	
	
	public Ninja() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getVillaggio() {
		return villaggio;
	}
	public void setVillaggio(String villaggio) {
		this.villaggio = villaggio;
	}
	@Override
	public String toString() {
		return "Ninja [id=" + id + ", nome=" + nome + ", villaggio=" + villaggio + "]";
	}
	
	

	
}
