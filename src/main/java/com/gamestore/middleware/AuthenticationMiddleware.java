package com.gamestore.middleware;

// import java.io.IOException;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import com.gamestore.config.JwtConfiguration;
// import com.gamestore.service.UserService;

// import io.jsonwebtoken.ExpiredJwtException;

// @Component
// public class AuthenticationMiddleware {//extends OncePerRequestFilter {
// 	@Autowired
// 	private UserService userService;

// 	@Autowired
// 	private JwtConfiguration jwtConfiguration;

// 	// @Override
// 	// protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
// 	// 		throws ServletException, IOException {

// 	// 	final String requestTokenHeader = request.getHeader("Authorization");

// 	// 	String username = null;
// 	// 	String jwtToken = null;
// 	// 	if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
// 	// 		jwtToken = requestTokenHeader.substring(7);
// 	// 		try {
// 	// 			username = jwtConfiguration.getUsernameFromToken(jwtToken);
// 	// 		} catch (IllegalArgumentException e) {
// 	// 			System.out.println("Unable to get JWT Token");
// 	// 		} catch (ExpiredJwtException e) {
// 	// 			System.out.println("JWT Token has expired");
// 	// 		}
// 	// 	} else {
// String");
// 	// 	}

// 	// 	if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
// 	// 		User user = this.userService.get(username);
// 	// 		if (jwtConfiguration.validateToken(jwtToken, userDetails)) {

// 	// 			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
// 	// 					userDetails, null, userDetails.getAuthorities());
// 	// 			usernamePasswordAuthenticationToken
// 	// 					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
// 	// 			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
// 	// 		}
// 	// 	}
// 	// 	chain.doFilter(request, response);
// 	// }

// }
