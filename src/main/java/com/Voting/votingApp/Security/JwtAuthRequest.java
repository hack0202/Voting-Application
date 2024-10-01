package com.Voting.votingApp.Security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter

@AllArgsConstructor

@Builder
@ToString
public class JwtAuthRequest {

	private String email;
	
	private String password;
}
