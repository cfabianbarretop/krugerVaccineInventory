package ec.kruger.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.kruger.inventario.entity.VaccineType;
import ec.kruger.inventario.repository.VaccineTypeRepository;

@Service
public class VaccineTypeService {

	@Autowired
	private VaccineTypeRepository vaccineTypeRepository;

	public List<VaccineType> getAllVaccineTypes() {
		return vaccineTypeRepository.findAll();
	}

	public Optional<VaccineType> findById(Long id) {
		return vaccineTypeRepository.findById(id);
	}
}
