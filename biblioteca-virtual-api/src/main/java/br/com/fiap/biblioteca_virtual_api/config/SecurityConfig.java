package br.com.fiap.biblioteca_virtual_api.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    UserDetailsService userDatailsServoce() {

        return new InMemoryUserDetailsManager(List.of(
            User.withUsername("caio").password("{noop}12345").build()        
            
        ));

    }

}
