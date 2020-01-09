package com.dubbo.util;
import com.dubbo.pojo.User;
import com.dubbo.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
@Component
public class UserDetailsImpl implements UserDetailsService{

	@Reference
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User se = userService.login(username);
		System.out.println(se);
		if(se!=null) {
			return se;
		}
		
		return null;
	}

}
