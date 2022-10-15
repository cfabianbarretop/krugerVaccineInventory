package ec.kruger.inventario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.kruger.inventario.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
