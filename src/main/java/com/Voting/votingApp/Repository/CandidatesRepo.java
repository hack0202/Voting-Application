package com.Voting.votingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Voting.votingApp.Entity.Candidates;

public interface CandidatesRepo extends JpaRepository<Candidates, Integer> 
{

}
