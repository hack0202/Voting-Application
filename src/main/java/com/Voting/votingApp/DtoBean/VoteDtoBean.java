package com.Voting.votingApp.DtoBean;

import com.Voting.votingApp.Entity.Candidates;
import com.Voting.votingApp.Entity.Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@AllArgsConstructor
@ToString
public class VoteDtoBean {
	  private Integer id;
	  private Users users;
	  private Candidates candidates;
	  
	  public VoteDtoBean() {
		  
	  }
}
