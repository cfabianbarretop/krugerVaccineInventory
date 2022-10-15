package ec.kruger.inventario.dto;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class RegisterPersonDTO {

	@NotEmpty(message = "The identification is required.")
	@Pattern(regexp = "[0-9]{10}", message = "In the identification field only number and a length of 10 characters are accepted.")
	private String identification;

	@NotEmpty(message = "The name is required.")
	@Pattern(regexp = "^[a-zA-Z ]{6,50}$", message = "In the name field only alphanumeric characters are accepted")
	private String name;

	@NotEmpty(message = "The lastname is required.")
	@Pattern(regexp = "^[a-zA-Z ]{6,50}$", message = "In the lastname field only alphanumeric characters are accepted")
	private String lastname;

	@NotEmpty(message = "The email is required.")
	@Email
	private String email;

	private Long id;

	private Date birthday;

	private String address;

	private String cellphone;

	private Long codVaccineStatus;

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Long getCodVaccineStatus() {
		return codVaccineStatus;
	}

	public void setCodVaccineStatus(Long codVaccineStatus) {
		this.codVaccineStatus = codVaccineStatus;
	}

}
