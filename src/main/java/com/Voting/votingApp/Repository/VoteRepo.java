package com.Voting.votingApp.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Voting.votingApp.Entity.Candidates;
import com.Voting.votingApp.Entity.Users;
import com.Voting.votingApp.Entity.Vote;

public interface VoteRepo extends JpaRepository<Vote, Integer> {
	 Optional<Vote> findByUsersAndCandidates(Users user, Candidates candidate);
	 boolean existsByUsers(Users user);
}
