package longobardo.giovanni.Hibernate;

import jakarta.persistence.Embeddable;

@Embeddable  // QUESTA CLASSE VIENE EMBEDDATA DENTRO UN'ALTRA QUANDO VA CARICATA NEL DB, altrimenti verrebbe create un'altra tabella
public class AlienoNome {

	
	private String nome;
	private String cognome;
	public AlienoNome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Override
	public String toString() {
		return "AlienoNome [nome=" + nome + ", cognome=" + cognome + "]";
	}
	
}
