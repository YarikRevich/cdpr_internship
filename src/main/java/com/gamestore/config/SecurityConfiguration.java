// package com.gamestore.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import com.gamestore.advice.AuthenticationAdvice;
// import com.gamestore.middleware.AuthenticationMiddleware;

// // @Configuration
// // @EnableWebSecurity
// // @EnableGlobalMethodSecurity(prePostEnabled = true)
// public class SecurityConfiguration {
// 	@Autowired
// 	private AuthenticationAdvice authenticationAdvice;

// 	@Autowired
// 	private AuthenticationMiddleware authenticationMiddleware;

// 	// @Autowired
// 	// public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
// 	// 	// configure AuthenticationManager so that it knows from where to load
// 	// 	// user for matching credentials
// 	// 	// Use BCryptPasswordEncoder
// 	// 	auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
// 	// }

// 	// @Bean
// 	// public PasswordEncoder passwordEncoder() {
// 	// 	return new BCryptPasswordEncoder();
// 	// }

// 	// @Bean
// 	// @Override
// 	// public AuthenticationManager authenticationManagerBean() throws Exception {
// 	// 	return super.authenticationManagerBean();
// 	// }

// 	// @Override
// 	// protected void configure(HttpSecurity httpSecurity) throws Exception {
// 	// 	httpSecurity.csrf().disable()
// 	// 			// dont authenticate this particular request
// 	// 			.authorizeRequests()
//     //             .antMatchers(
//     //                 "/authenticate",
//     //                 "**/games",
//     //                 "**/").
//     //             permitAll().
// 	// 			anyRequest().authenticated().and().
// 	// 			exceptionHandling().authenticationEntryPoint(authenticationAdvice).and().sessionManagement()
// 	// 			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

// 	// 	httpSecurity.addFilterBefore(authenticationMiddleware, UsernamePasswordAuthenticationFilter.class);
// 	// }
// }