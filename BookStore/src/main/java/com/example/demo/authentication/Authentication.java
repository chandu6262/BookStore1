package com.example.demo.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class Authentication extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("passwordadmin").roles("admin");
		auth.inMemoryAuthentication().withUser("user").password("passworduser").roles("user");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/books/add", "/books/update/{book_id}", "/books/delete/{book_id}",
				                             "/authors/add", "/authors/update/{author_id}", "/authors/delete/{author_id}",
				                             "/publishers/add", "/publishers/update/{publisher_id}", "/publishers/delete/{publisher_id}",
				                             "/rent/add", "/rent/update/{rental_id}", "/rent/delete/{rental_id}",
			                               	 "/RentedDetails/add", "/RentedDetails/update/{rentedDetails_id}", "/RentedDetails/delete/{rentedDetails_id}")
		                                     .hasAnyRole("admin").anyRequest().fullyAuthenticated().and().httpBasic();
	}
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}


}
