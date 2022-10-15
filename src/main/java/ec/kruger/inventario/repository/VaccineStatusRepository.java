package ec.kruger.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.kruger.inventario.entity.VaccineStatus;

public interface VaccineStatusRepository extends JpaRepository<VaccineStatus, Long>{

}
