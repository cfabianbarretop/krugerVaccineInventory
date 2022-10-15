package ec.kruger.inventario.contoller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.kruger.inventario.dto.RegisterPersonDTO;
import ec.kruger.inventario.entity.Person;
import ec.kruger.inventario.service.PersonService;
import ec.kruger.inventario.service.VaccineStatusService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/person/")
public class PersonREST {

	@Autowired
	private PersonService personService;
	@Autowired
	private VaccineStatusService vaccineStatusService;

	@Operation(summary = "Create or edit a person")
	@PostMapping
	private ResponseEntity<Person> create(@Valid @RequestBody RegisterPersonDTO registerPersonRequest) {
		Person person = new Person();
		person.setIdentification(registerPersonRequest.getIdentification());
		person.setName(registerPersonRequest.getName());
		person.setLastname(registerPersonRequest.getLastname());
		person.setEmail(registerPersonRequest.getEmail());
		person.setVaccineStatus(vaccineStatusService.findById((long) 2).get());
		if (registerPersonRequest.getId() != null) {
			person.setId(registerPersonRequest.getId());
		}
		Person personTem = personService.create(person);

		return new ResponseEntity<>(personTem, HttpStatus.CREATED);
	}

	@Operation(summary = "Get a list of people")
	@GetMapping
	private ResponseEntity<List<Person>> listPersons() {
		return ResponseEntity.ok(personService.getAllPersons());
	}

	@Operation(summary = "Delete a people by id")
	@DeleteMapping(value = "{id}")
	private ResponseEntity<Void> deletePerson(@PathVariable("id") Long id) {
		Optional<Person> person = personService.findById(id);
		personService.delete(person.get());
		return ResponseEntity.ok().build();
	}

	@Operation(summary = "Get a people by id")
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Person>> listPersonsByID(@PathVariable("id") Long id) {
		return ResponseEntity.ok(personService.findById(id));
	}

	@Operation(summary = "Update a people's information, only users with Employee role")
	@PostMapping("employee/update")
	private String update(@Valid @RequestBody RegisterPersonDTO registerPersonRequest) {
		Optional<Person> personTem = personService.findById(registerPersonRequest.getId());
		if (personTem.isEmpty()) {
			return "User does not exist";
		}
		Person person = personTem.get();
		person.setIdentification(registerPersonRequest.getIdentification());
		person.setName(registerPersonRequest.getName());
		person.setLastname(registerPersonRequest.getLastname());
		person.setEmail(registerPersonRequest.getEmail());
		person.setBirthday(registerPersonRequest.getBirthday());
		person.setAddress(registerPersonRequest.getAddress());
		person.setCellphone(registerPersonRequest.getCellphone());
		person.setVaccineStatus(vaccineStatusService.findById(registerPersonRequest.getCodVaccineStatus()).get());

		Person personTemp = personService.create(person);

		if (personTemp.getVaccineStatus().getId() == 1) {
			return "You must record your vaccination" ;
		}

		return "Successful update: " + HttpStatus.CREATED;
	}
}
