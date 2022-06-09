package com.guliver.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class HotelModel {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) // only mysql, below is Postgree
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	private String nomeHotel;
	private String codHotel;
	private String qtdHospedes;
	private String inicioReserva;
	private String fimReserva;
	private String valorReserva;
	private double nota;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeHotel() {
		return nomeHotel;
	}

	public void setNomeHotel(String nomeHotel) {
		this.nomeHotel = nomeHotel;
	}

	public String getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(String codHotel) {
		this.codHotel = codHotel;
	}

	public String getQtdHospedes() {
		return qtdHospedes;
	}

	public void setQtdHospedes(String qtdHospedes) {
		this.qtdHospedes = qtdHospedes;
	}

	public String getInicioReserva() {
		return inicioReserva;
	}

	public void setInicioReserva(String inicioReserva) {
		this.inicioReserva = inicioReserva;
	}

	public String getFimReserva() {
		return fimReserva;
	}

	public void setFimReserva(String fimReserva) {
		this.fimReserva = fimReserva;
	}

	public String getValorReserva() {
		return valorReserva;
	}

	public void setValorReserva(String valorReserva) {
		this.valorReserva = valorReserva;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
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
		HotelModel other = (HotelModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
