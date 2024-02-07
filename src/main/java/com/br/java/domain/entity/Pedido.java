package com.br.java.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pedido {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;
	private LocalDate dataPedido;
	private double total;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> itemPedido;

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public double getTotal() {
		return total;
	}
	

	public void setTotal(double d) {
		this.total = d;
	}
	  @Override
	    public String toString() {
	        return "Pedido{" +
	                "id=" + id +
	                ", dataPedido=" + dataPedido +
	                ", total=" + total +
	                "}";
	    }
}
