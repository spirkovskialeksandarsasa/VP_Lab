package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.Role;
import mk.ukim.finki.wp.lab.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> findAll();
    User findByUsername(String username);

    User register(String username, String password, String repeatPassword, Role role);

}
