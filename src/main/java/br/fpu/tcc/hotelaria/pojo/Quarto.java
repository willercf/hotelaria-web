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

import br.fpu.tcc.hotelaria.enums.CategoryQuarto;

@Entity
@Table(name = "tb_quarto")
public class Quarto implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private CategoryQuarto categoria;
	private String numero;
	private Long andar;;
	private BigDecimal preco;

	public Quarto() {

	}

	public Quarto(Long id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "categoria", nullable = false)
	@Enumerated(value = EnumType.ORDINAL)
	public CategoryQuarto getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoryQuarto categoria) {
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

	@Column(name = "preco", nullable = false)
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
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

}
