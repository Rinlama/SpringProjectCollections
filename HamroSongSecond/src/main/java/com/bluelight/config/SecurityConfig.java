package com.bluelight.config;

import javax.sql.DataSource;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.bluelight.services.UserService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Qualifier("userDetailsService")
	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private DataSource dataSource;
	
	    
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//		 auth.
//         jdbcAuthentication()
//         .dataSource(dataSource)
//         .passwordEncoder(passwordEncoder());
	
		// TODO Auto-generated method stub
			//auth.inMemoryAuthentication().
			//withUser("user1").password(passwordEncoder().encode("user1Pass"))
	        //  .authorities("USER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().httpBasic().and().authorizeRequests().antMatchers(HttpMethod.OPTIONS,"/authorize/**","/user/**").authenticated()
		.antMatchers(HttpMethod.OPTIONS,"/**").permitAll().and().logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).and()
		.csrf().disable().headers().frameOptions().disable();
	}
	
	
	

	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}

	

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
//		return new PasswordEncoder() {
//			
//			@Override
//			public boolean matches(CharSequence arg0, String arg1) {
//				// TODO Auto-generated method stub
//				return true;
//			}
//			
//			@Override
//			public String encode(CharSequence arg0) {
//				// TODO Auto-generated method stub
//				return arg0.toString();
//			}
//		};
	}
	
}
