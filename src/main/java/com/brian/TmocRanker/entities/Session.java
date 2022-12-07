package com.brian.TmocRanker.entities;


import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.*;

import com.brian.TmocRanker.request.CreateSessionRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sessions")
@JsonIgnoreProperties({"tmocker"})
public class Session {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long session_id;
	@Column(insertable = false, updatable = false)
	private long tmocker_id;
	private Integer ranking;
	@Column(name="start_time")
	private Timestamp start_time;
	@Column(name= "stop_time")
	private Timestamp stop_time;
	private int temp;
	private Long session_duration;
	private Date date;
	@ManyToOne
	@JoinColumn(name = "tmocker_id")
	private Tmocker tmocker;

	public Session (CreateSessionRequest createSessionRequest){
		this.tmocker_id = createSessionRequest.getTmocker_id();
		this.ranking = createSessionRequest.getRanking();
		this.start_time = createSessionRequest.getStart_time();
		this.stop_time = createSessionRequest.getStop_time();
		this.temp = createSessionRequest.getTemp();
		this.session_duration = createSessionRequest.getSession_duration();
	}

	@Override
	public String toString() {
		return "Sessions [session_id=" + session_id + ", tmocker_id=" + ", ranking=" + ranking
				+ ", startTime=" + start_time + ", stopTime=" + stop_time + ", temp=" + temp + "]";
	}


}