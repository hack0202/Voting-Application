package com.Voting.votingApp.ServiceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Voting.votingApp.DtoBean.UsersDtobean;
import com.Voting.votingApp.Entity.UserRole;
import com.Voting.votingApp.Entity.Users;
import com.Voting.votingApp.Repository.UsersRepo;
import com.Voting.votingApp.Service.UsersService;
@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public String saveUser(UsersDtobean usersDtobean) {
		Users users = new Users();
		users.setEmail(usersDtobean.getEmail());
		users.setName(usersDtobean.getName());
		users.setPassword(passwordEncoder.encode(usersDtobean.getPassword()));
		users.setPhoneNumber(usersDtobean.getPhoneNumber());
		users.setUserrole(new HashSet<>());
		
		UserRole userRole = new UserRole();
		userRole.setName("USER");
		userRole.setUsers(users);
		
		Set<UserRole> role = new HashSet<UserRole>();
		role.add(userRole);
		users.setUserrole(role);
		usersRepo.save(users);
		return "Users saved successfully";
	}

}
