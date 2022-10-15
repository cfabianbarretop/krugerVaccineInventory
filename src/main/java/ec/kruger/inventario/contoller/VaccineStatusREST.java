package ec.kruger.inventario.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.kruger.inventario.entity.VaccineStatus;
import ec.kruger.inventario.service.VaccineStatusService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/vaccineStatus/")
public class VaccineStatusREST {

	@Autowired
	private VaccineStatusService vaccineStatusService;
	
	@Operation(summary = "Get vaccine status list")
	@GetMapping
	private ResponseEntity<List<VaccineStatus>> listVaccineStatus() {
		return ResponseEntity.ok(vaccineStatusService.getAllVaccineStatus());
	}
}
