package br.fpu.tcc.hotelaria.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 2919261778403558880L;
	
	private long id_cliente;
	private String nome;
	private String endereco;
	private String cpf;
	private String email;
	private String telefone;
	
	public Cliente() {
		
	}
	
	public Cliente(long id_cliente, String nome, String endereco, String cpf,
			String email, String telefone) {
		super();
		this.id_cliente = id_cliente;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	@Id
	@GeneratedValue
	@Column(name = "id_cliente")
	public long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(long id_cliente) {
		this.id_cliente = id_cliente;
	}

	@Column(name = "nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "endereco")
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Column(name = "cpf")
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "telefone")
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
