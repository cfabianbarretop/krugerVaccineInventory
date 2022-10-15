package ec.kruger.inventario.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.kruger.inventario.entity.Role;
import ec.kruger.inventario.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/role/")
public class RoleREST {
	
	@Autowired
	private RoleService roleService;
	
	@Operation(summary = "Get role list")
	@GetMapping
	private ResponseEntity<List<Role>> listRoles() {
		return ResponseEntity.ok(roleService.getAllRoles());
	}

}
