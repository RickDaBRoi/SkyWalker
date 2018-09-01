package controle;

import daoGenerico.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Historico;

@ManagedBean
@ViewScoped
public class HistoricoMB {
	private Historico historico = new Historico();
	private List<Historico> historicos = new ArrayList<>();
	private DAOGenerico<Historico> dao = new DAOGenerico<>(Historico.class);

	public HistoricoMB() {
		historicos = dao.buscarTodos();
	}

	public void inserir() {
		if (historico.getIdHistorico() == null) {
			dao.salvar(historico);
		} else {
			dao.alterar(historico);
		}
		historico = new Historico();
		historicos = dao.buscarTodos();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		historicos = dao.buscarTodos();
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

}
