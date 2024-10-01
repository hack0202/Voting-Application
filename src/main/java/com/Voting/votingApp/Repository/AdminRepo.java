package com.Voting.votingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Voting.votingApp.Entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
Admin findByEmail(String email);
}
