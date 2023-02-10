package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Role;
import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.model.exceptions.*;
import mk.ukim.finki.wp.lab.repository.jpa.JpaUserRepository;
import mk.ukim.finki.wp.lab.service.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final JpaUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(JpaUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }


    @Override
    public User register(String username, String password, String repeatPassword, Role userRole) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username)!=null)
            throw new UsernameAlreadyExistsException();
        User user = new User(username,passwordEncoder.encode(password),userRole);
        return userRepository.save(user);
}
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}

