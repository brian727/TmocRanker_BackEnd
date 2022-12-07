package com.brian.TmocRanker.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class CreateSessionRequest {

    private long tmocker_id;
    private Integer ranking;
    private Timestamp start_time;
    private Timestamp stop_time;
    private int temp;
    private Long session_duration;
    private Date date;
}



