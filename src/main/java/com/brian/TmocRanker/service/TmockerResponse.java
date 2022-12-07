package com.brian.TmocRanker.service;

import com.brian.TmocRanker.entities.Tmocker;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TmockerResponse {
    private long tmocker_id;
    private String firstname;
    private String lastname;
    private String email;
    private int zip;
    private Integer ranking;
    public TmockerResponse(Tmocker tmocker){
        this.tmocker_id = tmocker.getTmocker_id();
        this.firstname = tmocker.getFirstname();
        this.lastname = tmocker.getLastname();
        this.email = tmocker.getEmail();
        this.zip = tmocker.getZipcode();
//        this.ranking = tmocker.getRanking();
    }
}
