package com.vancura.cz.vystavovac.service;

import com.vancura.cz.vystavovac.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService extends UserDetailsService {
    boolean createUser(User user);
    boolean updateUser(User user);
    User getUserDetails(Long id);
    User deleteUser(Long id);
    List<User> getAllUsers();
    User findByUsername(String username);
}
