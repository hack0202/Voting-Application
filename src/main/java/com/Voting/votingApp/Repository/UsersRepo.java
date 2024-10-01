package com.Voting.votingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Voting.votingApp.Entity.Users;

public interface UsersRepo extends JpaRepository<Users, Integer> {
Users findByEmail(String email);
}
