package controle;

import daoGenerico.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import modelo.Conteudo;

@ManagedBean
@ViewScoped
public class ConteudoMB {
	private Conteudo conteudo = new Conteudo();
	private List<Conteudo> conteudos = new ArrayList<>();
	private DAOGenerico<Conteudo> dao = new DAOGenerico<>(Conteudo.class);

	public ConteudoMB() {
		conteudos = dao.buscarTodos();
	}

	public void inserir() {
		if (conteudo.getIdConteudo() == null) {
			dao.salvar(conteudo);
		} else {
			dao.alterar(conteudo);
		}
		conteudo = new Conteudo();
		conteudos = dao.buscarTodos();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		conteudos = dao.buscarTodos();
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

}
