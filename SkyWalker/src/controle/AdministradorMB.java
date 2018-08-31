package controle;

import daoGenerico.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Administrador;

@ManagedBean
@ViewScoped
public class AdministradorMB {
	private Administrador administrador = new Administrador();
	private List<Administrador> administradores = new ArrayList<>();
	private DAOGenerico<Administrador> dao = new DAOGenerico<>(Administrador.class);

	public AdministradorMB() {
		administradores = dao.buscarTodos();
	}
	
	public void inserir() {
		if (administrador.getIdAdministrador() == null) {
			dao.salvar(administrador);
		} else {
			dao.alterar(administrador);
		}
		administrador = new Administrador();
		administradores = dao.buscarTodos();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		administradores = dao.buscarTodos();
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}
	
}
