package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Plano {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPlano;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private int valor;
	@Column(nullable = false)
	private String especificacao;

	public Plano() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((especificacao == null) ? 0 : especificacao.hashCode());
		result = prime * result + (int) (idPlano ^ (idPlano >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + valor;
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
		Plano other = (Plano) obj;
		if (especificacao == null) {
			if (other.especificacao != null)
				return false;
		} else if (!especificacao.equals(other.especificacao))
			return false;
		if (idPlano != other.idPlano)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (valor != other.valor)
			return false;
		return true;
	}

	public long getIdPlano() {
		return idPlano;
	}

	public void setIdPlano(long idPlano) {
		this.idPlano = idPlano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

}
