package com.vancura.cz.vystavovac.repository;

import com.vancura.cz.vystavovac.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
