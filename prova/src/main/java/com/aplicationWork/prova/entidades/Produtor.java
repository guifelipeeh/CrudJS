package com.aplicationWork.prova.entidades;



import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import jakarta.annotation.sql.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produtor implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numero_transacao")
    private String numeroTransacao;

    @Column(name = "data")
    private String data;

    @Column(name = "descricao_produto")
    private String descricaoProduto;

    @Column(name = "valor")
    private int valor;

    @Column(name = "nome_vendedor")
    private String nomeVendedor;

	
	public Produtor()
	{
		
	}

	public Produtor(String numeroTransacao, String data2, String descricaoProduto, int valor,
			String nomeVendedor, int id)
	{
		super();
		this.numeroTransacao = numeroTransacao;
		this.data = data2;
		this.descricaoProduto = descricaoProduto;
		this.valor = valor;
		this.nomeVendedor = nomeVendedor;
		this.id = id;
	
	}
	
	public String getNumeroTransacao() {
		return numeroTransacao;
	}
	public void setNumeroTransacao(String numeroTransacao) {
		this.numeroTransacao = numeroTransacao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getNomeVendedor() {
		return nomeVendedor;
	}
	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produtor other = (Produtor) obj;
		return id == other.id;
	}

	

	
	
}