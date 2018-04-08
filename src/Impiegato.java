
public class Impiegato {
	
	
	private int age;
	private String nome;
	private String cognome;
	
	public Impiegato(int age, String nome, String cognome) {
		this.age = age;
		this.nome = nome;
		this.cognome = cognome;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
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
		return "Impiegato [age=" + age + ", nome=" + nome + ", cognome=" + cognome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age; //non ha senso age.hashCode() perché l'hashCode di un intero è l'intero stesso
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		//cognome è null?se non è stato inizializzato utilizza 0 come valore di hashcode
		//altrimenti chiama il valore di hashCode() su questa stringa cioè viene elevato il valore di ciascun carattere per 31^(qualcosa)
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) //controlla se hanno lo stesso riferimento
			return true;
		if (obj == null) //controlla che riferimento all'oggetto non sia nullo
			return false;
		if (getClass() != obj.getClass()) //controlla che appartengano alla stessa classe
			return false;
		Impiegato other = (Impiegato) obj;
		if (age != other.age)
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}
