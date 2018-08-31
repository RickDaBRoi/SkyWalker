package controle;

import daoGenerico.DAOGenerico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Cartao;

@ManagedBean
@ViewScoped
public class CartaoMB {
	private Cartao cartao = new Cartao();
	private List<Cartao> cartoes = new ArrayList<>();
	private DAOGenerico<Cartao> dao = new DAOGenerico<>(Cartao.class);

	public CartaoMB() {
		cartoes = dao.buscarTodos();
	}

	public void inserir() {
		if (cartao.getIdCard() == null) {
			dao.salvar(cartao);
		} else {
			dao.alterar(cartao);
		}
		cartao = new Cartao();
		cartoes = dao.buscarTodos();
	}

	public void excluir(Long id) {
		dao.excluir(id);
		cartoes = dao.buscarTodos();
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

}
