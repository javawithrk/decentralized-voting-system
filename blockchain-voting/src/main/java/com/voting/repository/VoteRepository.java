package com.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.voting.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, String> {
}

