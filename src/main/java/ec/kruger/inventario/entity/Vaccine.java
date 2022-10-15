package ec.kruger.inventario.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "vaccine")
public class Vaccine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Date date;

	@NotNull
	private int dosis_number;

	@JoinColumn(name = "id_vaccine_type", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	private VaccineType vaccineType;

	@JoinColumn(name = "id_person", referencedColumnName = "ID")
	@ManyToOne(optional = false)
	private Person person;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDosis_number() {
		return dosis_number;
	}

	public void setDosis_number(int dosis_number) {
		this.dosis_number = dosis_number;
	}

	public VaccineType getVaccineType() {
		return vaccineType;
	}

	public void setVaccineType(VaccineType vaccineType) {
		this.vaccineType = vaccineType;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
