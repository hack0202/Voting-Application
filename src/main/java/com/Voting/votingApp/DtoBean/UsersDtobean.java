package com.Voting.votingApp.DtoBean;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class UsersDtobean {
	private int id;
	private String name;
	private String email;
	private String password;
	private String phoneNumber;
	public Set<UserRoleDtoBean> userRoleDtoBean = new  HashSet<UserRoleDtoBean>();
	
	
	public UsersDtobean() {
		
	}
	
}
