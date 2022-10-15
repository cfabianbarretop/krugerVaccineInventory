package ec.kruger.inventario.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.kruger.inventario.entity.Person;
import ec.kruger.inventario.entity.Vaccine;
import ec.kruger.inventario.entity.VaccineType;
import ec.kruger.inventario.repository.VaccineRepository;

@Service
public class VaccineService {

	@Autowired
	private VaccineRepository vaccineRepository;

	public Vaccine create (Vaccine vaccine) {
		return vaccineRepository.save(vaccine);
	}
	
	public List<Vaccine> getAllVaccines() {
		return vaccineRepository.findAll();
	}

	public List<Vaccine> getAllVaccineTypes(VaccineType vaccineType) {
		return vaccineRepository.findByVaccineType(vaccineType);
	}

	public List<Vaccine> getAllPersons(Person person) {
		return vaccineRepository.findByPerson(person);
	}
	
	public List<Vaccine> getAllDate(Date fistDate, Date lastDate) {
		System.out.println("Fechas: "+fistDate +" - "+ lastDate);
		return vaccineRepository.findByDate(fistDate, lastDate);
	}
}
