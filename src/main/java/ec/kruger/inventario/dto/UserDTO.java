package ec.kruger.inventario.dto;

public class UserDTO {
	private String username;
	private String password;
	private Long codPerson;
	private Long codRole;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCodPerson() {
		return codPerson;
	}

	public void setCodPerson(Long codPerson) {
		this.codPerson = codPerson;
	}

	public Long getCodRole() {
		return codRole;
	}

	public void setCodRole(Long codRole) {
		this.codRole = codRole;
	}

}
