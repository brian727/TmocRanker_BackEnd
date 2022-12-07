package com.brian.TmocRanker;

import com.brian.TmocRanker.entities.Session;
import com.brian.TmocRanker.entities.Tmocker;
import com.brian.TmocRanker.repos.SessionRepo;
import com.brian.TmocRanker.repos.TmockerRepo;
import com.brian.TmocRanker.service.SessionService;
import com.brian.TmocRanker.service.TmockerService;
import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
//import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
public class TmocRankerApplicationTests {

	@Autowired
	private TmockerRepo tmockerRepo;
	@Autowired
	private SessionRepo sessionRepo;
	@Autowired
	private TmockerService tmockerServiceImpl;
	@Autowired
	private SessionService sessionService;

	@Test
	public void contextLoads() {}

//ADD TMOCKER
//	@Test
//	public void CreateTmocker() {
//		Tmocker tmocker = new Tmocker();
//		tmocker.setFirstname("Rocket");
//		tmocker.setLastname("Dog");
//		tmocker.setEmail("rocket.gmail.com");
//		tmocker.setZipcode(85702);
////		tmocker.setRanking(1);
//		tmockerRepo.save(tmocker);
//	}

//FIND ALL TMOCKERS
	@Test
	public List<Tmocker> testfindAllTmockers() {

		return tmockerServiceImpl.getAllTmocker();
	}

//FIND PARTIAL DATA ON TMOCKERS (here all columns printed for demo purposes)
//	@Test
//	public void findAllTmockersPartial() {
//		List<Object[]> partialData = tmockerRepo.findAllTmockersPartial();
//		for (Object[] objects : partialData) {
//			//firstname column
//			System.out.println("#################FIND ALL PARTIAL TEST #################" + objects[0]);
//			//lastname column
//			System.out.println("#################FIND ALL PARTIAL TEST #################" + objects[1]);
//			//email column
//			System.out.println("#################FIND ALL PARTIAL TEST #################" + objects[2]);
//			//zipcode column
//			System.out.println("#################FIND ALL PARTIAL TEST #################" + objects[3]);
//			//ranking column
//			System.out.println("#################FIND ALL PARTIAL TEST #################" +objects[4]);
//		}
//	}

//FIND TMOCKER BY ID
//	@Test
//	public void findAllTmockersById() {
//		TmockerService tmockerService = null;
//		System.out.println("#################FIND BY ID TEST #################" + tmockerService.findById(30L));
//	}


//ADD SESSION
//	public void testAddSession() {
//		Session session = new Session();
//		session.setTmocker_id(23);
//		session.setTemp(75);
//		sessionRepo.save(session);
//	}


}

