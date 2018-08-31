package modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Conteudo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idConteudo;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String genero;
	@Column(nullable = false)
	private String tipo;
	@Column(nullable = false)
	private int indicacao;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date anoLancamento;
	@Column(nullable = false)
	private double tempoDuracao;

	public Conteudo() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoLancamento == null) ? 0 : anoLancamento.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + ((idConteudo == null) ? 0 : idConteudo.hashCode());
		result = prime * result + indicacao;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tempoDuracao);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Conteudo other = (Conteudo) obj;
		if (anoLancamento == null) {
			if (other.anoLancamento != null)
				return false;
		} else if (!anoLancamento.equals(other.anoLancamento))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (idConteudo == null) {
			if (other.idConteudo != null)
				return false;
		} else if (!idConteudo.equals(other.idConteudo))
			return false;
		if (indicacao != other.indicacao)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(tempoDuracao) != Double.doubleToLongBits(other.tempoDuracao))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	public Long getIdConteudo() {
		return idConteudo;
	}

	public void setIdConteudo(Long idConteudo) {
		this.idConteudo = idConteudo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getIndicacao() {
		return indicacao;
	}

	public void setIndicacao(int indicacao) {
		this.indicacao = indicacao;
	}

	public Date getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(Date anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public double getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(double tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

}
