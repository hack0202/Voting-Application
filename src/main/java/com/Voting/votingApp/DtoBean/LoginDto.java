package com.Voting.votingApp.DtoBean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class LoginDto {
	public String email;
	public String password;
	public LoginDto() {
		
	}
}
