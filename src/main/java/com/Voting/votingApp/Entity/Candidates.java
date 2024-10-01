package com.Voting.votingApp.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Candidates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
private int id;
private String name;
@Lob
@Column(columnDefinition = "LONGTEXT")
private String partyLogo;

private int voteCount=0;

@ManyToOne
@JoinColumn(name = "admin_id")
//@JsonManagedReference
private Admin admin;
}
