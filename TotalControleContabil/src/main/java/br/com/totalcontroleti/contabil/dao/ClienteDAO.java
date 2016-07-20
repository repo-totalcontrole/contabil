package br.com.totalcontroleti.contabil.dao;

import java.util.List;

import br.com.totalcontroleti.contabil.model.Cliente;

public interface ClienteDAO {
	
	public void addCliente(Cliente p);
	public void updateCliente(Cliente p);
	public List<Cliente> listCliente();
	public Cliente getClienteById(int id);
	public void removeCliente(int id);

}
