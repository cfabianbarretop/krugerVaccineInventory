package ec.kruger.inventario.dto;

import java.sql.Date;

public class FilterDTO {
	private String Filter;
	private Long codVaccineStatus;
	private Long codVaccineType;
	private Date vaccineFistDate;
	private Date vaccineLastDate;

	public String getFilter() {
		return Filter;
	}

	public void setFilter(String filter) {
		Filter = filter;
	}

	public Long getCodVaccineStatus() {
		return codVaccineStatus;
	}

	public void setCodVaccineStatus(Long codVaccineStatus) {
		this.codVaccineStatus = codVaccineStatus;
	}

	public Long getCodVaccineType() {
		return codVaccineType;
	}

	public void setCodVaccineType(Long codVaccineType) {
		this.codVaccineType = codVaccineType;
	}

	public Date getVaccineFistDate() {
		return vaccineFistDate;
	}

	public void setVaccineFistDate(Date vaccineFistDate) {
		this.vaccineFistDate = vaccineFistDate;
	}

	public Date getVaccineLastDate() {
		return vaccineLastDate;
	}

	public void setVaccineLastDate(Date vaccineLastDate) {
		this.vaccineLastDate = vaccineLastDate;
	}

}
