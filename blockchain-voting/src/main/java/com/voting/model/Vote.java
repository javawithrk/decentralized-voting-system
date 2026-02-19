package com.voting.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vote {

    @Id
    private String voterId;   // Each voter can vote only once

    private String candidate;

    public Vote() {
    }

    public Vote(String voterId, String candidate) {
        this.voterId = voterId;
        this.candidate = candidate;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }
}
