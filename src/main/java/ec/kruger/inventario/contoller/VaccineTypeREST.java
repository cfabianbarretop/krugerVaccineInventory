package ec.kruger.inventario.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.kruger.inventario.entity.VaccineType;
import ec.kruger.inventario.service.VaccineTypeService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/vaccineType/")
public class VaccineTypeREST {

	@Autowired
	private VaccineTypeService vaccineTypeService;
	
	@Operation(summary = "Get vaccine type list")
	@GetMapping
	private ResponseEntity<List<VaccineType>> listVaccineTypes() {
		return ResponseEntity.ok(vaccineTypeService.getAllVaccineTypes());
	}
}
