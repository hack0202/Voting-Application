package com.Voting.votingApp.ServiceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.Voting.votingApp.DtoBean.CandidatesDtoBean;
import com.Voting.votingApp.Entity.Admin;
import com.Voting.votingApp.Entity.Candidates;
import com.Voting.votingApp.Entity.Users;
import com.Voting.votingApp.Entity.Vote;
import com.Voting.votingApp.Exception.ResourceNotFoundException;
import com.Voting.votingApp.Repository.AdminRepo;
import com.Voting.votingApp.Repository.CandidatesRepo;
import com.Voting.votingApp.Repository.UsersRepo;
import com.Voting.votingApp.Repository.VoteRepo;
import com.Voting.votingApp.Service.CandidateService;

import jakarta.transaction.Transactional;
@Service
public class CandidateServiceImpl implements CandidateService{
	@Autowired 
	private CandidatesRepo candidatesRepo;
	
	@Autowired 
	private AdminRepo adminRepo;
	@Autowired
	private VoteRepo voteRepo;
	@Autowired
	private UsersRepo usersRepo;

	@Override
	public String createCandidate(CandidatesDtoBean candidatesDtoBean, int adminId) throws Exception {
		  Admin admin = adminRepo.findById(adminId)
	                .orElseThrow(() -> new ResourceNotFoundException("Admin", "id", adminId));
		  
		  Candidates candidates = new Candidates();
		  candidates.setName(candidatesDtoBean.getName());
		  candidates.setPartyLogo(candidatesDtoBean.getPartyLogo());
		  candidates.setVoteCount(candidatesDtoBean.getVoteCount());
		  candidates.setAdmin(admin); // Set the admin for the candidate
		  candidatesRepo.save(candidates);
		return "Candidate saved ";
	}
	@Transactional
	@Override
	public String voteForCandidate(int candidateId, int userId) throws Exception {
	    Candidates candidate = candidatesRepo.findById(candidateId)
	            .orElseThrow(() -> new ResourceNotFoundException("Candidate", "id", candidateId));
	    Users user = usersRepo.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

	    // Check if the user has already voted for any candidate
	    if (voteRepo.existsByUsers(user)) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You have already voted for a candidate. You cannot vote again.");
	    }

	    // If the user hasn't voted, allow them to vote for the current candidate
	    candidate.setVoteCount(candidate.getVoteCount() + 1);
	    candidatesRepo.save(candidate);
	    
	    Vote vote = new Vote();
	    vote.setUsers(user);
	    vote.setCandidates(candidate);
	    voteRepo.save(vote);

	    return "Vote successfully recorded";
	}

	@Override
	public List<CandidatesDtoBean> getAllCandidates() {
	    List<Candidates> candidates = candidatesRepo.findAll();
	    return candidates.stream()
	            .map(candidate -> new CandidatesDtoBean(candidate.getId(), candidate.getName(), candidate.getPartyLogo(), candidate.getVoteCount(), candidate.getAdmin()))
	            .collect(Collectors.toList());
	}



}
