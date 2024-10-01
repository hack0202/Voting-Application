package com.Voting.votingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Voting.votingApp.DtoBean.AdminDtoBean;
import com.Voting.votingApp.Service.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:5173/")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/saveAdmin")
	public String saveAdmin(@RequestBody AdminDtoBean adminDtoBean) {
		return adminService.saveAdmin(adminDtoBean);
	}

}
