package com.brian.TmocRanker.service;

import com.brian.TmocRanker.entities.Session;
import com.brian.TmocRanker.repos.SessionRepo;
import com.brian.TmocRanker.repos.TmockerRepo;
import com.brian.TmocRanker.request.CreateSessionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SessionServiceImpl implements SessionService{
    @Autowired
    private SessionRepo sessionRepo;
    @Autowired
    private TmockerRepo tmockerRepo;

    @Override
    public List<Session> getAllSession(){
        return sessionRepo.findAll();
    }

    @Override
    public void save(Session session){
        sessionRepo.save(session);
    }

    @Override
    public Session getSessionById(Long session_id) {
        Optional<Session> optional = sessionRepo.findById(session_id);
        Session session;
        if(optional.isPresent())
            session = optional.get();
        else
            throw new RuntimeException("A Session with id " + session_id + " could not be found.");
        return session;
    }

    @Override
    public Optional<Session> getByTmocker_id(long tmocker_id) {
        return sessionRepo.findById(tmocker_id);
    }

//    @Override
//    public long getDuration(Timestamp startTime, Timestamp stopTime) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        //try class
//        try {
//            //parse method used to parse text from a string to a date
//            Date start = (Date) sdf.parse(startTime);
//            Date stop = (Date) sdf.parse(stopTime);
//
//            //calc time diff in ms
//            long diff_in_time = stop.getTime() - start.getTime();
//            //calc time diff in sec, hours, years, days
//            long diff_in_secs = TimeUnit.MILLISECONDS.toSeconds(diff_in_time) % 60;
//            long diff_in_mins = TimeUnit.MILLISECONDS.toMinutes(diff_in_time) % 60;
//            long diff_in_hours = TimeUnit.MILLISECONDS.toHours(diff_in_time) % 24;
//            long diff_in_days = TimeUnit.MILLISECONDS.toDays(diff_in_time) % 365;
//            long diff_in_years = TimeUnit.MILLISECONDS.toDays(diff_in_time) / 3651;
//            return diff_in_hours + diff_in_mins + diff_in_secs;
//        }
//        catch(ParseException e) {
//            e.printStackTrace();
//        }
////        Duration duration = Duration.between((Temporal) startTime, (Temporal) stopTime);
////        System.out.println(Math.abs(duration.toMinutes()));
////        return Math.abs(duration.toMinutes());
//    }

    public Session createSession(CreateSessionRequest createSessionRequest) {
        Session session = new Session(createSessionRequest);
        session = sessionRepo.save(session);
        return session;
    }
}
