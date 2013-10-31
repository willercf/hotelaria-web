package br.fpu.tcc.hotelaria.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.fpu.tcc.hotelaria.enums.StatusReserva;

@Entity
@Table(name = "tb_reserva")
public class Reserva implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Funcionario funcionario;
	private Cliente cliente;
	private Quarto quarto;
	private Date dataInicio;
	private Date dataFim;
	private StatusReserva statusReserva;
	private CheckIn checkIn;
	private CheckOut checkOut;

	public Reserva() {
		super();
		init();
	}

	public Reserva(long id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_funcionario", nullable = false)
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", nullable = false)
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_quarto", nullable = false)
	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	@Column(name = "data_inicio", nullable = false)
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Column(name = "data_fim", nullable = false)
	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Column(name = "status", nullable = false)
	@Enumerated(value = EnumType.ORDINAL)
	public StatusReserva getStatusReserva() {
		return statusReserva;
	}

	public void setStatusReserva(StatusReserva statusReserva) {
		this.statusReserva = statusReserva;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "reserva")
	public CheckIn getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(CheckIn checkIn) {
		this.checkIn = checkIn;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "reserva")
	public CheckOut getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(CheckOut checkOut) {
		this.checkOut = checkOut;
	}

	@Transient
	public boolean isDisableEdit() {
		return !StatusReserva.RESERVED.equals(statusReserva);
	}

	@Transient
	public boolean isDisableDetail() {
		return !StatusReserva.CHECK_IN.equals(statusReserva) && !StatusReserva.CHECK_OUT.equals(statusReserva);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private void init() {
		this.quarto = new Quarto();
		this.cliente = new Cliente();
	}
}
