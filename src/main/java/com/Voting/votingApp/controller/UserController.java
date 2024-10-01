package com.Voting.votingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Voting.votingApp.DtoBean.UsersDtobean;
import com.Voting.votingApp.Service.UsersService;

@RestController
@RequestMapping("/user")
public class UserController {
@Autowired
private UsersService usersService;

@PostMapping("/saveUser")
public String saveUser(@RequestBody UsersDtobean usersDtobean) {
	return usersService.saveUser(usersDtobean);
}
}
