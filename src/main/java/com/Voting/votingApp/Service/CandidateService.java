package com.Voting.votingApp.Service;

import java.util.List;

import com.Voting.votingApp.DtoBean.CandidatesDtoBean;
import com.Voting.votingApp.Entity.Candidates;

public interface CandidateService {
String createCandidate(CandidatesDtoBean candidatesDtoBean ,int adminId) throws Exception;
public String voteForCandidate(int candidateId ,int userId) throws Exception ;
public List<CandidatesDtoBean> getAllCandidates() ;
}
