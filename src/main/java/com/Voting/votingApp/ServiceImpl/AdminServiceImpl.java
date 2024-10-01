package com.Voting.votingApp.ServiceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Voting.votingApp.DtoBean.AdminDtoBean;
import com.Voting.votingApp.Entity.Admin;
import com.Voting.votingApp.Entity.AdminRole;
import com.Voting.votingApp.Repository.AdminRepo;
import com.Voting.votingApp.Service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	 private AdminRepo adminRepo;

	@Override
	public String saveAdmin(AdminDtoBean adminDtoBean) {
		Admin admin = new Admin();
		admin.setName(adminDtoBean.getName());
		admin.setPassword(passwordEncoder.encode(adminDtoBean.getPassword()));
		admin.setPhoneNumber(adminDtoBean.getPhoneNumber());
		admin.setEmail(adminDtoBean.getEmail());
		admin.setAdminrole(new HashSet<>());
		
		AdminRole adminRole = new AdminRole();
		adminRole.setName("Admin");
		adminRole.setAdmin(admin);
		
		Set<AdminRole> role= new HashSet<AdminRole>();
		role.add(adminRole);
		admin.setAdminrole(role);
		adminRepo.save(admin);
		
		return "Admin saved successfully";
	}

}
