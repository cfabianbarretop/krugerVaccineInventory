package ec.kruger.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.kruger.inventario.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
