package br.com.totalcontroleti.contabil.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.totalcontroleti.contabil.dao.UsuarioDAO;
import br.com.totalcontroleti.contabil.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private UsuarioDAO UsuarioDAO;

	public void setUsuarioDAO(UsuarioDAO UsuarioDAO) {
		this.UsuarioDAO = UsuarioDAO;
	}

	@Override
	@Transactional
	public void addUsuario(Usuario p) {
		this.UsuarioDAO.addUsuario(p);
	}

	@Override
	@Transactional
	public void updateUsuario(Usuario p) {
		this.UsuarioDAO.updateUsuario(p);
	}

	@Override
	@Transactional
	public List<Usuario> listUsuarios() {
		return this.UsuarioDAO.listUsuarios();
	}

	@Override
	@Transactional
	public Usuario getUsuarioById(int id) {
		return this.UsuarioDAO.getUsuarioById(id);
	}

	@Override
	@Transactional
	public void removeUsuario(int id) {
		this.UsuarioDAO.removeUsuario(id);
	}

}
