package org.spring.security.jwt.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.spring.security.jwt.utill.Constant;
import org.spring.security.jwt.utill.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilter extends OncePerRequestFilter{

	@Resource(name="JwtTokenUtil")
	private JwtTokenUtil jwtUtil;
	
	@Resource(name=Constant.USER_DETAILS_SERVICE_RESOURCE)
	private UserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse responce, FilterChain filterchain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authorization = request.getHeader("Authorization");
		String token = null;
		String username = null;
		
		if(authorization!=null && authorization.startsWith("Bearer ")){
			token = authorization.substring(7);
			username = jwtUtil.getUsernameFromToken(token);
		}
		
		if(username != null){
			UserDetails userDetails =userDetailsService.loadUserByUsername(username);
			
			if(jwtUtil.validateToken(token, userDetails)){
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						new UsernamePasswordAuthenticationToken(userDetails, null , userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
			
		}
		filterchain.doFilter(request, responce);
		
	}

	
	
	
	
	
	
}
