package longobardo.giovanni.Hibernate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="alien_table")  // CAMBI IL NOME DELLA TABELLA NEL DB ( di default è il nome della classe )
public class Alieno {
	
	@Id
	private int id;
	// @Transient // IL NOME NON VIENE SALVATO NEL DB
	private AlienoNome nome;
	@Column(name="colorepazzo") // CAMBIA IL NOME DELLA COLONNA NEL DB ( di default è il nome dell'attribut)
	private String colore;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colore == null) ? 0 : colore.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Alieno other = (Alieno) obj;
		if (colore == null) {
			if (other.colore != null)
				return false;
		} else if (!colore.equals(other.colore))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Alieno [id=" + id + ", nome=" + nome + ", colore=" + colore + "]";
	}
	public Alieno() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public AlienoNome getNome() {
		return nome;
	}
	public void setNome(AlienoNome nome) {
		this.nome = nome;
	}
	public String getColore() {
		return colore;
	}
	public void setColore(String colore) {
		this.colore = colore;
	}
	
	
}
