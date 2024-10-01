package com.Voting.votingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Voting.votingApp.DtoBean.CandidatesDtoBean;
import com.Voting.votingApp.Entity.Candidates;
import com.Voting.votingApp.Service.CandidateService;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/candidate")
public class CandidatesController {
@Autowired
private CandidateService candidateService;


@PostMapping("/create/{adminId}")
public ResponseEntity<String> createCandidate(@RequestBody CandidatesDtoBean candidatesDtoBean, @PathVariable int adminId) {
    try {
        String message = candidateService.createCandidate(candidatesDtoBean, adminId);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>("Error creating candidate: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
@PostMapping("/vote/{candidateId}/user/{userId}")
public ResponseEntity<String> voteForCandidate(@PathVariable int candidateId, @PathVariable int userId) {
    try {
        String message = candidateService.voteForCandidate(candidateId, userId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>("Error voting for candidate: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
@GetMapping("/all")
public ResponseEntity<List<CandidatesDtoBean>> getAllCandidates() {
    try {
        List<CandidatesDtoBean> candidates = candidateService.getAllCandidates(); // Ensure this method returns CandidatesDtoBean
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


}
