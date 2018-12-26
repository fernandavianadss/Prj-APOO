package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.dominio.Situacao;

/**
 * Classe responsavel por persistir a classe Situação no banco de dados.
 * 
 * @author fernanda viana
 * @version 1.0 
 */

public class SituacaoDAO {
	private EntityManager manager;

	public SituacaoDAO() {
		super();

		this.manager = JPAUtil.getEntityManager();
	}

	public Situacao salvar(Situacao situacao) {
		this.manager.getTransaction().begin();
		situacao = this.manager.merge(situacao);
		this.manager.getTransaction().commit();
		return situacao;
	}

	public void excluir(Situacao situacao) {
		this.manager.getTransaction().begin();
		this.manager.remove(situacao);
		this.manager.getTransaction().commit();
	}

	public Situacao obter(Integer id) {
		return this.manager.find(Situacao.class, id);
	}

	public List<Situacao> listar() {

		String jpql = "from Situacao s order by s.nome";

		List<Situacao> lista = this.manager.createQuery(jpql, Situacao.class).getResultList();

		return lista;
	}
}
