package com.finalproject.sales.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tb_sales")
public class Sales implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull
    @Min(2)
	@Column 
	private Integer velocidade;
	@Column 
	private double preco;
	@Column 
	private Date dataPedido;
	@Column 
	private Date dataInstalacao;
	@Column
	private String cliente;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Integer getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Date getDataInstalacao() {
		return dataInstalacao;
	}
	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
}
