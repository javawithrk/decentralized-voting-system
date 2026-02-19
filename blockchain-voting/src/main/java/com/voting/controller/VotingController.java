package com.voting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.voting.model.Vote;
import com.voting.service.VotingService;

@RestController
@RequestMapping("/api/vote")
public class VotingController {

    @Autowired
    private VotingService votingService;

    @PostMapping
    public String vote(@RequestBody Vote vote) {
        return votingService.castVote(vote);
    }

    @GetMapping("/chain")
    public Object getBlockchain() {
        return votingService.viewBlockchain();
    }
    
    @GetMapping("/validate")
    public String validateChain() {

        boolean valid = votingService.validateBlockchain();

        if (valid) {
            return "Blockchain is VALID. No tampering detected.";
        } else {
            return "Blockchain is CORRUPTED!";
        }
    }

}

