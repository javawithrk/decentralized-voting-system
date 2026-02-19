package com.voting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.voting.blockchain.Blockchain;
import com.voting.model.Vote;
import com.voting.repository.VoteRepository;

@Service
public class VotingService {

    private Blockchain blockchain = new Blockchain();

    @Autowired
    private VoteRepository voteRepository;

    public String castVote(Vote vote) {

        // Prevent double voting
        if (voteRepository.existsById(vote.getVoterId())) {
            return "You have already voted!";
        }

        // Save to database
        voteRepository.save(vote);

        // Add to blockchain
        blockchain.addBlock(vote.getVoterId(), vote.getCandidate());

        return "Vote recorded successfully!";
    }

    public Object viewBlockchain() {
        return blockchain.getChain();
    }
    
    public boolean validateBlockchain() {
        return blockchain.isChainValid();
    }

}

