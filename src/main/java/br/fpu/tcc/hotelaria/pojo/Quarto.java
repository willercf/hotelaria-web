package br.fpu.tcc.hotelaria.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.fpu.tcc.hotelaria.enums.CategoryQuarto;

@Entity
@Table(name = "tb_quarto")
public class Quarto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private CategoryQuarto tipo;
	private Long numero;
	private Long andar;;
	private BigDecimal preco;

	public Quarto() {

	}

	private Quarto(Long id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue
	@Column(name = "id_quarto")
	public long getId_quarto() {
		return id_quarto;
	}

	public void setId_quarto(long id_quarto) {
		this.id_quarto = id_quarto;
	}

	@Column(name = "tipo")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "preco")
	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "reserva", referencedColumnName = "id_reserva")
	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

}
