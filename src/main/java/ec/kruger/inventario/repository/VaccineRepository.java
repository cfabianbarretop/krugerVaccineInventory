package ec.kruger.inventario.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ec.kruger.inventario.entity.Person;
import ec.kruger.inventario.entity.Vaccine;
import ec.kruger.inventario.entity.VaccineType;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
	List<Vaccine> findByVaccineType(VaccineType vaccineType);
	
	List<Vaccine> findByPerson(Person person);
	
	@Query(value = "SELECT u FROM Vaccine u WHERE u.date BETWEEN ?1 AND ?2 ")
	List<Vaccine> findByDate(Date fistDate, Date lastDate);
}
