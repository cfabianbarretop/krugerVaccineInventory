package ec.kruger.inventario.contoller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.kruger.inventario.dto.FilterDTO;
import ec.kruger.inventario.entity.Person;
import ec.kruger.inventario.entity.Vaccine;
import ec.kruger.inventario.entity.VaccineStatus;
import ec.kruger.inventario.entity.VaccineType;
import ec.kruger.inventario.service.PersonService;
import ec.kruger.inventario.service.VaccineService;
import ec.kruger.inventario.service.VaccineStatusService;
import ec.kruger.inventario.service.VaccineTypeService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("api/filter/vaccine/")
public class FilterREST {

	@Autowired
	private PersonService personService;
	@Autowired
	private VaccineStatusService vaccineStatusService;
	@Autowired
	private VaccineTypeService vaccineTypeService;
	@Autowired
	private VaccineService vaccineService;
	
	@Operation(summary = "Get a list of people filtered by status, type and date of vaccination")
	@PostMapping
	private ResponseEntity<List<Person>> filterByStatus(@RequestBody FilterDTO filterRequest) {
		List<Person> persons = new ArrayList<>();
		
		if (filterRequest.getFilter().equalsIgnoreCase("status")) {
			Optional<VaccineStatus> vaccineStatus = vaccineStatusService.findById(filterRequest.getCodVaccineStatus());
			persons = personService.getPersonsByVaccineStatus(vaccineStatus.get());
		}
		if (filterRequest.getFilter().equalsIgnoreCase("type")) {
			Optional<VaccineType> vaccineType = vaccineTypeService.findById(filterRequest.getCodVaccineType());
			List<Vaccine> vaccines = vaccineService.getAllVaccineTypes(vaccineType.get());
			for (Iterator<Vaccine> iterator = vaccines.iterator(); iterator.hasNext();) {
				Vaccine vaccine = (Vaccine) iterator.next();
				persons.add(vaccine.getPerson());
			}
		}
		if (filterRequest.getFilter().equalsIgnoreCase("date")) {
			List<Vaccine> vaccines = vaccineService.getAllDate(filterRequest.getVaccineFistDate(), filterRequest.getVaccineLastDate());
			for (Iterator<Vaccine> iterator = vaccines.iterator(); iterator.hasNext();) {
				Vaccine vaccine = (Vaccine) iterator.next();
				persons.add(vaccine.getPerson());
			}
		}
		

		return new ResponseEntity<>(persons, HttpStatus.CREATED);
	}

}
