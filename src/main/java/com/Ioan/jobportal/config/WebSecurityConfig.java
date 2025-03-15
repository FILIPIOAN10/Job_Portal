
/**
 * Pachetul `com.Ioan.jobportal.config` conține configurările principale
 * pentru securitate, MVC și comportamente personalizate de autentificare/autorizare
 * în aplicația JobPortal.
 */

package com.Ioan.jobportal.config;


import com.Ioan.jobportal.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {


    private final CustomUserDetailsService customUserDetailsService;

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;


    public WebSecurityConfig(CustomUserDetailsService customUserDetailsService,CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.customUserDetailsService = customUserDetailsService;
        this.customAuthenticationSuccessHandler=customAuthenticationSuccessHandler;
    }


    private final String[] publicUrl = {"/",
            "/global-search/**",
            "/register",
            "/register/**",
            "/webjars/**",
            "/resources/**",
            "/assets/**",
            "/css/**",
            "/summernote/**",
            "/js/**",
            "/*.css",
            "/*.js",
            "/*.js.map",
            "/fonts*", "/favicon.ico", "/resources/*", "/error"};


    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authenticationProvider(authenticationProvider());

        http.authorizeHttpRequests(auth->{
            auth.requestMatchers(publicUrl).permitAll();
            auth.anyRequest().authenticated();
        });
        http.formLogin(form->form.loginPage("/login").permitAll().successHandler(customAuthenticationSuccessHandler))
                .logout(logout->{
                    logout.logoutUrl("/logout");
                    logout.logoutSuccessUrl("/");
                }).cors(Customizer.withDefaults())
                .csrf(csfr->csfr.disable());
        return http.build();
    }



    @Bean
    public AuthenticationProvider authenticationProvider() {

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(customUserDetailsService);
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
