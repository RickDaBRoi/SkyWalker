package controle;

import daoGenerico.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.ClienteTitular;

@ManagedBean
@ViewScoped
public class ClienteTitularMB {
	private ClienteTitular clienteTitular = new ClienteTitular();
	private List<ClienteTitular> clientesTitulares = new ArrayList<>();
	private DAOGenerico<ClienteTitular> dao = new DAOGenerico<>(ClienteTitular.class);

	public ClienteTitularMB() {
		clientesTitulares = dao.buscarTodos();
	}

	public void inserir() {
		if (clienteTitular.getIdCliente() == null) {
			dao.salvar(clienteTitular);
		} else {
			dao.alterar(clienteTitular);
		}
		clienteTitular = new ClienteTitular();
		clientesTitulares = dao.buscarTodos();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		clientesTitulares = dao.buscarTodos();
	}

	public ClienteTitular getClienteTitular() {
		return clienteTitular;
	}

	public void setClienteTitular(ClienteTitular clienteTitular) {
		this.clienteTitular = clienteTitular;
	}

	public List<ClienteTitular> getClientesTitulares() {
		return clientesTitulares;
	}

	public void setClientesTitulares(List<ClienteTitular> clientesTitulares) {
		this.clientesTitulares = clientesTitulares;
	}

}
