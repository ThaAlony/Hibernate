package longobardo.giovanni.HibernateCache;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable   // QUESTA ENTITA PUO' ANDARE NELLA CACHE DI SCONDO LIVELLO!!
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)  // QUESTA ENTITA VA NELLA CACHE SOLO PER ESSERE LETTA !!
public class Criceto {

	@Id
	private int id;
	private String nome;
	private char sesso;
	public Criceto() {
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
	public char getSesso() {
		return sesso;
	}
	public void setSesso(char sesso) {
		this.sesso = Character.toUpperCase(sesso);
	}
	@Override
	public String toString() {
		return "Criceto [id=" + id + ", nome=" + nome + ", sesso=" + sesso + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + sesso;
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
		Criceto other = (Criceto) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sesso != other.sesso)
			return false;
		return true;
	}
	
	
}
