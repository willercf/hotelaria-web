package br.fpu.tcc.hotelaria.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.fpu.tcc.hotelaria.enums.CategoriaQuarto;

@Entity
@Table(name = "tb_quarto")
public class Quarto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private CategoriaQuarto categoria;
	private String numero;
	private Long andar;;
	private BigDecimal precoDiaria;

	public Quarto() {

	}

	public Quarto(Long id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_quarto", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "categoria", nullable = false)
	@Enumerated(value = EnumType.ORDINAL)
	public CategoriaQuarto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaQuarto categoria) {
		this.categoria = categoria;
	}

	@Column(name = "numero", nullable = false, length = 5)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "andar", nullable = false)
	public Long getAndar() {
		return andar;
	}

	public void setAndar(Long andar) {
		this.andar = andar;
	}

	@Column(name = "preco_diaria", nullable = false)
	public BigDecimal getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(BigDecimal precoDiaria) {
		this.precoDiaria = precoDiaria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Quarto other = (Quarto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String patter = "Número: %s | Andar: %d | Categoria: %s";
		return String.format(patter, numero, andar, categoria.getDescription());
	}

}
