package br.com.totalcontroleti.contabil.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.totalcontroleti.contabil.model.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	private static final Logger logger = LoggerFactory.getLogger(ClienteDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addUsuario(Cliente p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Cliente saved successfully, Cliente Details="+p);
	}

	public void updateCliente(Cliente p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Cliente updated successfully, Cliente Details="+p);
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> listCliente() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Cliente> ClienteList = session.createQuery("from Cliente").list();
		for(Cliente p : ClienteList){
			logger.info("Cliente List::"+p);
		}
		return ClienteList;
	}

	public Cliente getUsuarioById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Cliente p = (Cliente) session.load(Cliente.class, new Integer(id));
		logger.info("Cliente loaded successfully, Cliente details="+p);
		return p;
	}

	public void removeCliente(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cliente p = (Cliente) session.load(Cliente.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Cliente deleted successfully, Cliente details="+p);
	}

	public void addCliente(Cliente p) {
		// TODO Auto-generated method stub
		
	}

	public Cliente getClienteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
