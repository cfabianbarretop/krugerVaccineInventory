package ec.kruger.inventario.dto;

import java.sql.Date;

public class VaccineDTO {

	private int dosisNumber;
	private Date date;
	private Long codVaccineType;
	private Long codPerson;

	public int getDosisNumber() {
		return dosisNumber;
	}

	public void setDosisNumber(int dosisNumber) {
		this.dosisNumber = dosisNumber;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getCodVaccineType() {
		return codVaccineType;
	}

	public void setCodVaccineType(Long codVaccineType) {
		this.codVaccineType = codVaccineType;
	}

	public Long getCodPerson() {
		return codPerson;
	}

	public void setCodPerson(Long codPerson) {
		this.codPerson = codPerson;
	}
}
