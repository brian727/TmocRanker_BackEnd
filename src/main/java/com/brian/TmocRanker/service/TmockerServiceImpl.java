package com.brian.TmocRanker.service;

import com.brian.TmocRanker.entities.Tmocker;
import com.brian.TmocRanker.repos.TmockerRepo;
import com.brian.TmocRanker.request.CreateTmockerRequest;
import com.brian.TmocRanker.request.UpdateTmockerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TmockerServiceImpl implements TmockerService {
    @Autowired
    private TmockerRepo tmockerRepo;

    @Override
    public List<Tmocker> getAllTmocker(){
        return tmockerRepo.findAll();
    }

    @Override
    public void save(Tmocker tmocker){
        tmockerRepo.save(tmocker);
    }

    @Override
    public Tmocker getTmockerById(Long id) {
        Optional<Tmocker> optional = tmockerRepo.findById(id);
        Tmocker tmocker;
        if(optional.isPresent())
            tmocker = optional.get();
        else
            throw new RuntimeException("A Tmocker with id " + id + " could not be found.");
        return tmocker;
    }

    @Override
    public void deleteById(long tmocker_id) {
        tmockerRepo.deleteById(tmocker_id);
    }

    public List<Tmocker> findByEmail(String email) {
        return tmockerRepo.findByEmail(email);
    }

    public Tmocker createTmocker(CreateTmockerRequest createTmockerRequest) {
        Tmocker tmocker = new Tmocker(createTmockerRequest);
        tmocker = tmockerRepo.save(tmocker);
        return tmocker;
    }

    public Tmocker updateTmocker (UpdateTmockerRequest updateTmockerRequest) {
    Tmocker tmocker = tmockerRepo.findById(updateTmockerRequest.getTmocker_id()).get();
        //update for firstname
            if(updateTmockerRequest.getFirstname() != null && !updateTmockerRequest.getFirstname().isEmpty()) {
                tmocker.setFirstname(updateTmockerRequest.getFirstname());
            }

        //update for lastname
            if(updateTmockerRequest.getLastname() != null && !updateTmockerRequest.getLastname().isEmpty()) {
                tmocker.setLastname(updateTmockerRequest.getLastname());
            }
        //update for email
            if(updateTmockerRequest.getEmail() != null && !updateTmockerRequest.getEmail().isEmpty()) {
                tmocker.setEmail(updateTmockerRequest.getEmail());
            }

        //update for zipcode
            if(updateTmockerRequest.getZipcode() !=0 ) {
                tmocker.setZipcode(updateTmockerRequest.getZipcode());
            }

        tmocker = tmockerRepo.save(tmocker);
        return tmocker;
    }
}
