package com.Voting.votingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Voting.votingApp.Entity.AdminRole;

public interface AdminRoleRepo extends JpaRepository<AdminRole, Integer>{

}
