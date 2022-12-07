package com.brian.TmocRanker.service;

import com.brian.TmocRanker.entities.Session;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;


@Getter
@Setter
public class SessionResponse {
    private final Date date;
    private long session_id;
    private long session_duration;
    private Timestamp start_time;
    private Timestamp stop_time;
    private int temp;
    private int ranking;

    public SessionResponse (Session session) {
        this.session_id = session.getSession_id();
        this.session_duration = session.getSession_duration();
        this.start_time = session.getStart_time();
        this.stop_time = session.getStop_time();
        this.temp = session.getTemp();
        this.ranking = session.getRanking();
        this.date = session.getDate();
    }


}
