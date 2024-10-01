package com.Voting.votingApp.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Vote {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	  @ManyToOne
	  @JoinColumn(name = "user_id") 
	  @JsonManagedReference
	    private Users users;
	  @ManyToOne
	  @JoinColumn(name = "candidate_id") 
	  @JsonManagedReference
	  private Candidates candidates;
}
