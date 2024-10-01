package com.Voting.votingApp.Service;

import org.springframework.web.bind.annotation.RequestBody;

import com.Voting.votingApp.DtoBean.UsersDtobean;

public interface UsersService {
public String saveUser(@RequestBody UsersDtobean usersDtobean);
}
