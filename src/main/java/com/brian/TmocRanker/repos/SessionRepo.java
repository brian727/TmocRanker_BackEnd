package com.brian.TmocRanker.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.brian.TmocRanker.entities.*;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepo extends JpaRepository<Session, Long> {

}
