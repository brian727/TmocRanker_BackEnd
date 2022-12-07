package com.brian.TmocRanker.entities;


import com.brian.TmocRanker.request.CreateTmockerRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="tmockers")
public class Tmocker {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long tmocker_id;
	private String firstname;
	private String lastname;

//	private int ranking;
	private String email;
	private Integer zipcode;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tmocker")
	private List<Session> sessionLog;

	public Tmocker (CreateTmockerRequest createTmockerRequest){
		this.firstname = createTmockerRequest.getFirstname();
		this.lastname = createTmockerRequest.getLastname();
		this.email = createTmockerRequest.getEmail();
		this.zipcode = createTmockerRequest.getZipcode();
	}

	@Override
	public String toString() {
		return "Tmocker{" +
				"tmocker_id=" + tmocker_id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
//				", ranking=" + ranking +
				", email='" + email + '\'' +
				", zipcode=" + zipcode +
				'}';
	}
}