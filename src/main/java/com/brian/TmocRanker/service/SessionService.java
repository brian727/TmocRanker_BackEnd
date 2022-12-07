package com.brian.TmocRanker.service;

import com.brian.TmocRanker.entities.Session;

import java.util.List;
import java.util.Optional;

public interface SessionService {
    List<Session> getAllSession();
    void save(Session session);
    Session getSessionById(Long session_id);
//    long getDuration(Timestamp startTime, Timestamp stopTime);

//    long getDuration(String startTime, String stopTime);
    Optional<Session> getByTmocker_id(long tmocker_id);

}
