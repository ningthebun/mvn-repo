package com.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.login.auth.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("At Authen configure");
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("At Security configure");
		http
			.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("pw")
				.loginProcessingUrl("/loginProcess")
				.failureUrl("/loginProcess")
				.permitAll()
				.defaultSuccessUrl("/loginSuccess", true) // loginSuccessHandler()
			.and()
			.csrf()
			.and()
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/home").permitAll()
				.antMatchers("/css/**").permitAll()
				.antMatchers("/images/**").permitAll()
				.antMatchers("/js/**").permitAll()
				.antMatchers(HttpMethod.GET, "/favicon.*").permitAll()
				.antMatchers(HttpMethod.GET, "/loginProcess").permitAll()
				.antMatchers(HttpMethod.POST, "/loginProcess").permitAll()
				.antMatchers(HttpMethod.GET, "/adminPage").hasRole("Manager") // --------- Manager -----------
				.antMatchers(HttpMethod.POST, "/adminPage").hasRole("Manager")
				.antMatchers(HttpMethod.GET, "/dashboard").hasAnyRole("Manager", "User") // --------- All -----------
				.antMatchers(HttpMethod.POST, "/dashboard").hasAnyRole("Manager", "User")
			.and()
			.logout()
				.logoutSuccessUrl("/logout")
				.invalidateHttpSession(true)
				.deleteCookies("PortalSession");
	}
}
