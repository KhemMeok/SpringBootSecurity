package project_api.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.AllArgsConstructor;
import project_api.config.securiy.ApplicationUserService;
import project_api.config.securiy.PermissionEnum;
import project_api.config.securiy.RoleEnum;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .authorizeRequests()
            .antMatchers("/index.html", "/home").permitAll()
            .antMatchers("/api/user/users").hasAnyRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/user/delete").hasAuthority(PermissionEnum.USER_WRITE.getDescription())
                .antMatchers(HttpMethod.GET,"/api/user").hasAnyAuthority(PermissionEnum.USER_READ.getDescription(),PermissionEnum.USER_WRITE.getDescription())
            .anyRequest().authenticated()
        .and()
        .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getAuthenticationProvider());
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return  provider;
    }

    //    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        // UserDetails user = new User("khim", passwordEncoder.encode("Khim2002") , getAuthorities());
//        UserDetails khim = User.builder()
//        .username("khim")
//        .password(passwordEncoder.encode("khim2002"))
////        .roles("ADMIN")
//                .authorities(RoleEnum.ADMIN.getAuthorities())
//        .build();
//        UserDetails khat = User.builder()
//        .username("khat")
//        .password(passwordEncoder.encode("khat2002"))
////        .roles("USER")
//                .authorities(RoleEnum.USER.getAuthorities())
//        .build();
//
//        UserDetailsService userDetailsService = new InMemoryUserDetailsManager(khim,khat);
//
//        return userDetailsService;
//    }

//    private Collection<? extends GrantedAuthority> getAuthorities() {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return authorities;
//    }
}
