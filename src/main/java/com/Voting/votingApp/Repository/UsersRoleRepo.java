package com.Voting.votingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Voting.votingApp.Entity.UserRole;

public interface UsersRoleRepo extends JpaRepository<UserRole, Integer> {

}
