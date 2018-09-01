package controle;

import daoGenerico.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Plano;

@ManagedBean
@ViewScoped
public class PlanoMB {
	private Plano plano = new Plano();
	private List<Plano> planos = new ArrayList<>();
	private DAOGenerico<Plano> dao = new DAOGenerico<>(Plano.class);

	public PlanoMB() {
		planos = dao.buscarTodos();
	}

	public void inserir() {
		if (plano.getIdPlano() == null) {
			dao.salvar(plano);
		} else {
			dao.alterar(plano);
		}
		plano = new Plano();
		planos = dao.buscarTodos();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		planos = dao.buscarTodos();
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

}
