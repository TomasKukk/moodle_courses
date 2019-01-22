package com.example.moodle_courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.moodle_courses.web.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(user);
//	}
	
	// evätään pyynnöt kaikkialle paitsi /css alkuiset
	// forwardataan kaikki pyynnöt login sivustolle
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers("/css/**").permitAll()
	        .and()
	        .authorizeRequests().antMatchers("/img/**").permitAll()
	        .and()
	        .authorizeRequests().anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/index")
			.permitAll()
			.and()
		.logout()
			.permitAll();
			
	}
	
	// encodataan käyttäjän syöttämä salasana ja verrataan db:ssä olevaan hashiin
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
