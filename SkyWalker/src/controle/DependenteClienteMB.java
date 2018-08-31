package controle;

import daoGenerico.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.DependenteCliente;

@ManagedBean
@ViewScoped
public class DependenteClienteMB {
	private DependenteCliente dependenteCliente = new DependenteCliente();
	private List<DependenteCliente> dependenteClientes = new ArrayList<>();
	private DAOGenerico<DependenteCliente> dao = new DAOGenerico<>(DependenteCliente.class);

	public DependenteClienteMB() {
		dependenteClientes = dao.buscarTodos();
	}
	
	public void inserir() {
		if (dependenteCliente.getIdDependente() == null) {
			dao.salvar(dependenteCliente);
		} else {
			dao.alterar(dependenteCliente);
		}
		dependenteCliente = new DependenteCliente();
		dependenteClientes = dao.buscarTodos();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		dependenteClientes = dao.buscarTodos();
	}

	public DependenteCliente getDependenteCliente() {
		return dependenteCliente;
	}

	public void setDependenteCliente(DependenteCliente dependenteCliente) {
		this.dependenteCliente = dependenteCliente;
	}

	public List<DependenteCliente> getDependenteClientes() {
		return dependenteClientes;
	}

	public void setDependenteClientes(List<DependenteCliente> dependenteClientes) {
		this.dependenteClientes = dependenteClientes;
	}
	
	
}
