package com.voting.blockchain;

import java.time.LocalDateTime;

public class Block {

    private String voterId;
    private String candidate;
    private LocalDateTime timestamp;
    private String previousHash;
    private String hash;

    public Block(String voterId, String candidate, String previousHash) {
        this.voterId = voterId;
        this.candidate = candidate;
        this.previousHash = previousHash;
        this.timestamp = LocalDateTime.now();
        this.hash = calculateHash();
    }

    // Generates hash for this block
    public String calculateHash() {
        String data = voterId + candidate + timestamp + previousHash;
        return HashUtil.sha256(data);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getVoterId() {
        return voterId;
    }

    public String getCandidate() {
        return candidate;
    }
}

