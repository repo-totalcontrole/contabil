package br.com.totalcontroleti.contabil.dao;

import java.util.List;

import br.com.totalcontroleti.contabil.model.Usuario;

public interface UsuarioDAO {

	public void addUsuario(Usuario p);
	public void updateUsuario(Usuario p);
	public List<Usuario> listUsuarios();
	public Usuario getUsuarioById(int id);
	public void removeUsuario(int id);
}
