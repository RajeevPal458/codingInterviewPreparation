package org.spring.security.jwt.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.spring.security.jwt.utill.Constant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sun.javafx.scene.paint.GradientUtils;

@Service(Constant.USER_DETAILS_SERVICE_RESOURCE) 
public class UserDetailsServiceImpl implements UserDetailsService , Serializable{

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		List<GrantedAuthority> authorities=new ArrayList<>();
		// TODO Auto-generated method stub
		//return new CustomUserDetails("rajpal", "BVos@1234", true, true, true, true, authorities);
		if("rajpal".equals(name))
			return new User("rajpal" ,"BVos@1234",new ArrayList<>());
		else
			throw new UsernameNotFoundException("Username Not Found");
	}

}
