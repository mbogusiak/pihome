package com.marcin.pihome.integration.weather;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.marcin.pihome.dao.UserDao;
import com.marcin.pihome.user.User;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("ASDASDASDASDASD");
		return new UserDetails() {
			
			public boolean isEnabled() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public boolean isCredentialsNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public boolean isAccountNonLocked() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public boolean isAccountNonExpired() {
				// TODO Auto-generated method stub
				return true;
			}
			
			public String getUsername() {
				// TODO Auto-generated method stub
				return "mbogusiak@gmail.com	";
			}
			
			public String getPassword() {
				// TODO Auto-generated method stub
				return "password";
			}
			
			public Collection<? extends GrantedAuthority> getAuthorities() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	public User findUserByID(String userID) {
		return userDao.getUserById(userID);
	}
	
	
		
	

}