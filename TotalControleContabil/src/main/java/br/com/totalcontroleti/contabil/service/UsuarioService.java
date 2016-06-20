package br.com.totalcontroleti.contabil.service;

import java.util.List;

import br.com.totalcontroleti.contabil.model.Usuario;

public interface UsuarioService {

	public void addUsuario(Usuario p);
	public void updateUsuario(Usuario p);
	public List<Usuario> listUsuarios();
	public Usuario getUsuarioById(int id);
	public void removeUsuario(int id);
	
}
