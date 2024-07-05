package net.safedata.springboot.training.d05.s01.config;

import net.safedata.springboot.training.d05.s01.handler.FailedAuthHandler;
import net.safedata.springboot.training.d05.s01.handler.PostLogoutHandler;
import net.safedata.springboot.training.d05.s01.handler.SuccessfulAuthHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(this::configureAuth)
            .formLogin(this::configureFormLogin)
            .logout(this::configureLogout);

        return http.build();
    }

    private AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry
            configureAuth(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry authorizeRequests) {
        return authorizeRequests.requestMatchers("/static/**").permitAll()
                                .requestMatchers(HttpMethod.POST, "/admin")
                                .hasAnyRole(Roles.ADMIN_ROLE, Roles.MANAGER_ROLE)
                                .requestMatchers(HttpMethod.GET, "/product")
                                .fullyAuthenticated()
                                .requestMatchers(HttpMethod.POST, "/product")
                                .hasAuthority("WRITE")
                                .anyRequest().authenticated();
    }

    private FormLoginConfigurer<HttpSecurity> configureFormLogin(FormLoginConfigurer<HttpSecurity> formLogin) {
        return formLogin.loginPage("/login")
                        .permitAll()
                        .successHandler(successfulAuthHandler())
                        .failureHandler(failedAuthHandler())
                        .defaultSuccessUrl("/")
                        .failureUrl("/login?error")
                        .usernameParameter("username")
                        .passwordParameter("password");
    }

    private LogoutConfigurer<HttpSecurity> configureLogout(LogoutConfigurer<HttpSecurity> logout) {
        return logout.permitAll()
                     .deleteCookies("JSESSIONID")
                     .clearAuthentication(true)
                     .addLogoutHandler(postLogoutHandler())
                     .logoutSuccessUrl("/login?logout=true");
    }

    @Bean
    public UserDetailsService userDetailsService() {
        final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("manager")
                               .password("password")
                               .roles(Roles.MANAGER_ROLE)
                               .authorities("READ")
                               .passwordEncoder(pass -> passwordEncoder().encode(pass))
                               .build());
        manager.createUser(User.withUsername("admin")
                               .password("admin")
                               .roles(Roles.ADMIN_ROLE)
                               .authorities("WRITE")
                               .passwordEncoder(pass -> passwordEncoder().encode(pass))
                               .build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public SuccessfulAuthHandler successfulAuthHandler() {
        return new SuccessfulAuthHandler();
    }

    @Bean
    public FailedAuthHandler failedAuthHandler() {
        return new FailedAuthHandler();
    }

    @Bean
    public PostLogoutHandler postLogoutHandler() {
        return new PostLogoutHandler();
    }
}