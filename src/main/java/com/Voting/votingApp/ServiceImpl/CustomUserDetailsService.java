package com.Voting.votingApp.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Voting.votingApp.Entity.Admin;
import com.Voting.votingApp.Entity.Users;
import com.Voting.votingApp.Repository.AdminRepo;
import com.Voting.votingApp.Repository.UsersRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private AdminRepo adminRepo;
	
	public CustomUserDetailsService(UsersRepo repo, AdminRepo admin) {
		this.usersRepo=repo;
		this.adminRepo=admin;
		
	}
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin= adminRepo.findByEmail(email);
		if(admin!=null) {

			return admin;
		}
		   Users user = usersRepo.findByEmail(email);
	        if (user != null) {
	            return user;
	        }
	        throw new UsernameNotFoundException("User not found with email: " + email);
		  
	}

}
