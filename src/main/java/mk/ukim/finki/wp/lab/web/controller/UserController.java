package mk.ukim.finki.wp.lab.web.controller;


import mk.ukim.finki.wp.lab.model.Role;
import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.model.exceptions.InvalidUserCredentialsException;
import mk.ukim.finki.wp.lab.service.AuthService;
import mk.ukim.finki.wp.lab.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    private static final List<String> USER_ROLES = List.of("ROLE_USER", "ROLE_ADMIN");
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder, AuthService authService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authService = authService;
    }
    @GetMapping("/login")
    public String getLoginPage(){

        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        User user = null;
        try{
            user = this.authService.login(request.getParameter("username"),
                    request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/listCourses";
        }
        catch (InvalidUserCredentialsException exception) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model){
        model.addAttribute("roles", USER_ROLES);
        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String repeatPassword,
            @RequestParam Role role) {
        User user = new User(username, password, role);
       this.userService.register(username,password,repeatPassword,role);
       return "redirect:/login";
    }
}


