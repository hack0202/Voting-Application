package com.Voting.votingApp.DtoBean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.Voting.votingApp.Entity.Candidates;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AdminDtoBean {
	private String name;
	private String email;
	private String password;
	private String phoneNumber;
	public Set<AdminRoleDtoBean> adminRoleDtoBean = new  HashSet<AdminRoleDtoBean>();
    private List<Candidates> candidates = new ArrayList<>();

}
