package com.brian.TmocRanker.service;

import com.brian.TmocRanker.entities.Tmocker;

import java.util.List;

public interface TmockerService {
    List<Tmocker> getAllTmocker();
    void save(Tmocker tmocker);
    Tmocker getTmockerById(Long tmocker_id);
    void deleteById(long tmocker_id);
}
