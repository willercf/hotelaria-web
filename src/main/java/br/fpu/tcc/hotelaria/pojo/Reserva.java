package br.fpu.tcc.hotelaria.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reserva")
public class Reserva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7674532674562211351L;
	private long id_reserva;
	private Funcionario funcionario;
	private Cliente cliente;
	private Quarto quarto;

	@Id
	@GeneratedValue
	@Column(name = "id_reserva")
	public long getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(long id_reserva) {
		this.id_reserva = id_reserva;
	}

//	@OneToMany
	@JoinColumn(name = "funcionario", referencedColumnName = "id_funcionario")
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

//	@OneToMany
	@JoinColumn(name = "cliente", referencedColumnName = "id_cliente")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reserva")
//	@JoinColumn(name = "quarto", referencedColumnName = "id_quarto")
	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

}
