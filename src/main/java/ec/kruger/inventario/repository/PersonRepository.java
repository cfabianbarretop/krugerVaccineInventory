package ec.kruger.inventario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.kruger.inventario.entity.Person;
import ec.kruger.inventario.entity.VaccineStatus;

public interface PersonRepository extends JpaRepository<Person, Long> {
	List<Person> findByVaccineStatus(VaccineStatus vaccineStatus);
}
