package mk.ukim.finki.wp.lab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final CustomAuthenticationProvider customAuthenticationProvider;

    public WebSecurityConfig(PasswordEncoder passwordEncoder, CustomAuthenticationProvider customAuthenticationProvider) {
        this.passwordEncoder = passwordEncoder;
        this.customAuthenticationProvider = customAuthenticationProvider;
    }

    @Override
   protected void configure(HttpSecurity http) throws Exception{
       http.csrf().disable()
               .authorizeRequests()
               .antMatchers("/", "/courses", "/grades", "/register").permitAll()
               .antMatchers("/add/*").hasRole("ADMIN")
       .anyRequest().authenticated()
               .and()
               .formLogin()
               .loginPage("/login").permitAll()
               .failureUrl("/login?error=BadCredentials")
               .defaultSuccessUrl("/courses", true)
               .and()
               .logout().logoutUrl("/logout")
               .clearAuthentication(true)
               .invalidateHttpSession(true)
               .deleteCookies("JSESSIONID")
               .logoutSuccessUrl("/login");
   }

   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
   }

}
