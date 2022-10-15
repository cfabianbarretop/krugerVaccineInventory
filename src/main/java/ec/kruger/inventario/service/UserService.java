package ec.kruger.inventario.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.kruger.inventario.entity.User;
import ec.kruger.inventario.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User create (User User) {
		return userRepository.save(User);
	}
	
	public Optional<User> findByUsername (String username) {
		return userRepository.findByUsername(username);
	}
}
