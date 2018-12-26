package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import modelo.dominio.Veiculo;

/**
 * Classe responsavel por persistir a classe Veiculo no banco de dados.
 * 
 * @author fernanda viana
 * @version 1.0 
 */


public class VeiculoDAO {
	
	private EntityManager manager;
	
	public VeiculoDAO() {
		super();
		
		this.manager = JPAUtil.getEntityManager();
	}
	
	public Veiculo salvar(Veiculo veiculo) {
		this.manager.getTransaction().begin();
		veiculo = this.manager.merge(veiculo);
		this.manager.getTransaction().commit();
		return veiculo;
	}
	
	public void excluir (Veiculo veiculo) {
		this.manager.getTransaction().begin();
		this.manager.remove(veiculo);
		this.manager.getTransaction().commit();
	}
	
	public Veiculo obter(Integer id) {
		return this.manager.find(Veiculo.class, id);
	}
	
	public List<Veiculo> listar(){
		
		String jpql = "from Veiculo v order by v.placa";
		
		List<Veiculo> lista = this.manager.createQuery(jpql, Veiculo.class).getResultList();
			
		return lista;
		}
	}
