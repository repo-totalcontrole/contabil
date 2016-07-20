package br.com.totalcontroleti.contabil.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entidade referente aos atributos do processo
 * @author Cleber Silva
 *
 */

@Entity
@Table(name="PROCESSOS")
public class Processos {
	
	@Id
	@Column(name="id_processo")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_processo;
	
	private int numeroProcesso;
	private String varaDoProcesso;
	private String requerente;
	private String requerido;
	private String dataDoInicioDoProcesso;
	
	public int getId_processo() {
		return id_processo;
	}
	public void setId_processo(int id_processo) {
		this.id_processo = id_processo;
	}
	public int getNumeroProcesso() {
		return numeroProcesso;
	}
	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}
	public String getVaraDoProcesso() {
		return varaDoProcesso;
	}
	public void setVaraDoProcesso(String varaDoProcesso) {
		this.varaDoProcesso = varaDoProcesso;
	}
	public String getRequerente() {
		return requerente;
	}
	public void setRequerente(String requerente) {
		this.requerente = requerente;
	}
	public String getRequerido() {
		return requerido;
	}
	public void setRequerido(String requerido) {
		this.requerido = requerido;
	}
	public String getDataDoInicioDoProcesso() {
		return dataDoInicioDoProcesso;
	}
	public void setDataDoInicioDoProcesso(String dataDoInicioDoProcesso) {
		this.dataDoInicioDoProcesso = dataDoInicioDoProcesso;
	}
	
	
	

}
