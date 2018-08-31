package modelo;

import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TemporalType;

@Entity
public class Historico {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idHistorico;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAcesso;

	public Historico() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAcesso == null) ? 0 : dataAcesso.hashCode());
		result = prime * result + (int) (idHistorico ^ (idHistorico >>> 32));
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
		Historico other = (Historico) obj;
		if (dataAcesso == null) {
			if (other.dataAcesso != null)
				return false;
		} else if (!dataAcesso.equals(other.dataAcesso))
			return false;
		if (idHistorico != other.idHistorico)
			return false;
		return true;
	}

	public long getIdHistorico() {
		return idHistorico;
	}

	public void setIdHistorico(long idHistorico) {
		this.idHistorico = idHistorico;
	}

	public Date getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}

}
