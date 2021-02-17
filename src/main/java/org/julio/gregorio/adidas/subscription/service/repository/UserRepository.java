package org.julio.gregorio.adidas.subscription.service.repository;

import java.util.Optional;

import org.julio.gregorio.adidas.subscription.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByName(String name);

}