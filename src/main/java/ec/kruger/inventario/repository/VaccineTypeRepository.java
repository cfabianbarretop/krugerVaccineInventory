package ec.kruger.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.kruger.inventario.entity.VaccineType;

public interface VaccineTypeRepository extends JpaRepository<VaccineType, Long> {

}
