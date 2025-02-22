package Donation_application.example.Donation_login.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class Securityconfig {
    @Bean
    public SecurityFilterChain sfc(HttpSecurity httpsecurity) throws Exception {
        return httpsecurity
                .formLogin(httpForm ->{
                    httpForm
                        .loginPage("/login").permitAll();
                })

                .authorizeHttpRequests(registry ->{
                    registry.requestMatchers("/req/signup").permitAll();
                    registry.anyRequest().authenticated();
                })

                .build();
    }
}
