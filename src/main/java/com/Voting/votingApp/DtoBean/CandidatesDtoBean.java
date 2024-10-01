package com.Voting.votingApp.DtoBean;

import com.Voting.votingApp.Entity.Admin;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class CandidatesDtoBean {
	private int id;
	private String name;
	private String partyLogo;

	private int voteCount;
	private Admin admin;
	
}
