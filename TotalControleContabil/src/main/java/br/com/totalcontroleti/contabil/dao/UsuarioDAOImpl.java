package br.com.totalcontroleti.contabil.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.totalcontroleti.contabil.model.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(UsuarioDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addUsuario(Usuario p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Usuario saved successfully, Usuario Details="+p);
	}

	@Override
	public void updateUsuario(Usuario p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Usuario updated successfully, Usuario Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listUsuarios() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Usuario> UsuariosList = session.createQuery("from Usuario").list();
		for(Usuario p : UsuariosList){
			logger.info("Usuario List::"+p);
		}
		return UsuariosList;
	}

	@Override
	public Usuario getUsuarioById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Usuario p = (Usuario) session.load(Usuario.class, new Integer(id));
		logger.info("Usuario loaded successfully, Usuario details="+p);
		return p;
	}

	@Override
	public void removeUsuario(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Usuario p = (Usuario) session.load(Usuario.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Usuario deleted successfully, Usuario details="+p);
	}

}
