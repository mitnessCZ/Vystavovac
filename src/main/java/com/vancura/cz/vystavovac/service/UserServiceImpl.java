package com.vancura.cz.vystavovac.service;

import com.vancura.cz.vystavovac.model.User;
import com.vancura.cz.vystavovac.repository.UserRepository;
import com.vancura.cz.vystavovac.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        Optional<User> userDB = userRepository.findById(user.getId());
        if (userDB.isPresent()) {
            // Zkontrolujte, zda je třeba heslo aktualizovat
            if (!user.getPassword().equals(userDB.get().getPassword())) {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User getUserDetails(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User deleteUser(Long id) {
        Optional<User> userDB = userRepository.findById(id);
        if (userDB.isPresent()) {
            User user = userDB.get();
            userRepository.delete(user);
            return user;
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Uživatel nenalezen");
        }
        return new MyUserDetails(user);
    }
}
