package ec.kruger.inventario.contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.kruger.inventario.dto.VaccineDTO;
import ec.kruger.inventario.entity.Person;
import ec.kruger.inventario.entity.Vaccine;
import ec.kruger.inventario.entity.VaccineType;
import ec.kruger.inventario.service.PersonService;
import ec.kruger.inventario.service.VaccineService;
import ec.kruger.inventario.service.VaccineTypeService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/vaccine/")
public class VaccineREST {

	@Autowired
	private VaccineService vaccineService;
	@Autowired
	private PersonService personService;
	@Autowired
	private VaccineTypeService vaccineTypeService;
	
	@Operation(summary = "Register a employee vaccine")
	@PostMapping
	private ResponseEntity<Vaccine> create(@RequestBody VaccineDTO vaccineRequest) {
		Optional<Person> person = personService.findById(vaccineRequest.getCodPerson());
		Optional<VaccineType> vaccineType = vaccineTypeService.findById(vaccineRequest.getCodVaccineType());
		Vaccine vaccine = new Vaccine();
		
		if(person.isEmpty()) {
			return new ResponseEntity<>(vaccine, HttpStatus.CREATED);
		}
		if(vaccineType.isEmpty()) {
			return new ResponseEntity<>(vaccine, HttpStatus.CREATED);
		}
		
		vaccine.setDosis_number(vaccineRequest.getDosisNumber());
		vaccine.setDate(vaccineRequest.getDate());
		vaccine.setPerson(person.get());
		vaccine.setVaccineType(vaccineType.get());
		Vaccine vaccineTem = vaccineService.create(vaccine);

		return new ResponseEntity<>(vaccineTem, HttpStatus.CREATED);
	}

	@Operation(summary = "Get vaccine list")
	@GetMapping
	private ResponseEntity<List<Vaccine>> listVaccines() {
		return ResponseEntity.ok(vaccineService.getAllVaccines());
	}
}
