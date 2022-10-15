package ec.kruger.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.kruger.inventario.entity.Person;
import ec.kruger.inventario.entity.VaccineStatus;
import ec.kruger.inventario.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public Person create (Person person) {
		return personRepository.save(person);
	}
	
	public List<Person> getAllPersons (){
		return personRepository.findAll();
	}
	
	public void delete (Person person) {
		personRepository.delete(person);
	}
	
	public Optional<Person> findById (Long id) {
		return personRepository.findById(id);
	}
	
	public List<Person> getPersonsByVaccineStatus (VaccineStatus vaccineStatus){
		return personRepository.findByVaccineStatus(vaccineStatus);
	}
}
