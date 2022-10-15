package ec.kruger.inventario.contoller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.kruger.inventario.dto.LoginDTO;
import ec.kruger.inventario.dto.UserDTO;
import ec.kruger.inventario.entity.Person;
import ec.kruger.inventario.entity.Role;
import ec.kruger.inventario.entity.User;
import ec.kruger.inventario.service.PersonService;
import ec.kruger.inventario.service.RoleService;
import ec.kruger.inventario.service.UserService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/user/")
public class UserREST {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private PersonService personService;

	@Operation(summary = "create a user, after creating a person, only make the user with Administrator role")
	@PostMapping
	private ResponseEntity<User> create(@RequestBody UserDTO userRequest) {
		Optional<Role> role = roleService.findById(userRequest.getCodRole());
		Optional<Person> person = personService.findById(userRequest.getCodPerson());
		
		if (person.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		if (role.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		User user = new User();
		user.setActive(1);
		user.setPassword(userRequest.getPassword());
		user.setUsername(userRequest.getUsername());
		user.setPerson(person.get());
		user.setRole(role.get());
		User userTem = userService.create(user);

		try {
			return ResponseEntity.created(new URI("/api/user" + userTem.getId())).body(userTem);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@Operation(summary = "Allows users to login")
	@PostMapping("login")
	private String login(@RequestBody LoginDTO loginRequest) {
		Optional<User> user = userService.findByUsername(loginRequest.getUsername());
		if(user.isEmpty()) {
			return "User/Password incorrect";
		}
		return "User-ROLE: "+user.get().getRole().getDescription();
	}
}
