package controle;

import daoGenerico.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Pagamento;

@ManagedBean
@ViewScoped
public class PagamentoMB {
	private Pagamento pagamento = new Pagamento();
	private List<Pagamento> pagamentos = new ArrayList<>();
	private DAOGenerico<Pagamento> dao = new DAOGenerico<>(Pagamento.class);

	public PagamentoMB() {
		pagamentos = dao.buscarTodos();
	}

	public void inserir() {
		if (pagamento.getIdPagamento() == null) {
			dao.salvar(pagamento);
		} else {
			dao.alterar(pagamento);
		}
		pagamento = new Pagamento();
		pagamentos = dao.buscarTodos();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		pagamentos = dao.buscarTodos();
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public void setPagamentos(List<Pagamento> pagamentos) {
		this.pagamentos = pagamentos;
	}

}
