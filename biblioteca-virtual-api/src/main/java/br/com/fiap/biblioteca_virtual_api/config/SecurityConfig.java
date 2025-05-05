package br.com.fiap.biblioteca_virtual_api.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/reviews/**").hasRole("ADMIN")
            // .anyRequest().hasAnyRole("ADMIN", "USER")
            .requestMatchers(HttpMethod.POST,"/users/**").permitAll()
            .anyRequest().authenticated()
        ) 
        .httpBasic(Customizer.withDefaults())
        .csrf(csrf -> csrf.disable())
        .build();
    }
    
    // @Bean
    // UserDetailsService userDatailsServoce() {

    //     return new InMemoryUserDetailsManager(List.of(
    //         User
    //             .withUsername("caio")
    //             .password("$2a$12$KDEQuqJe525PqBvWoH/mBuHQqseBxPpSr1ARuyTqvZUfIofgBkRcm")
    //             .roles("ADMIN")
    //             .build(),        

    //         User
    //             .withUsername("celina")
    //             .password("$2a$12$VwLzJ6SfrlZwvuzKfAwqRecbbsUYLkWVVg44QOEL9lRdIq9dvbApq")
    //             .roles("USER")
    //             .build()        

    //         )
    //     );
    // }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
