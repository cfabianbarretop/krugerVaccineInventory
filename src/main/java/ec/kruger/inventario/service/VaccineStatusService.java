package ec.kruger.inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.kruger.inventario.entity.VaccineStatus;
import ec.kruger.inventario.repository.VaccineStatusRepository;

@Service
public class VaccineStatusService {

	@Autowired
	private VaccineStatusRepository vaccineStatusRepository;

	public List<VaccineStatus> getAllVaccineStatus() {
		return vaccineStatusRepository.findAll();
	}

	public Optional<VaccineStatus> findById(Long id) {
		return vaccineStatusRepository.findById(id);
	}

}
