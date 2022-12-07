package com.brian.TmocRanker.controllers;

import com.brian.TmocRanker.entities.Session;
import com.brian.TmocRanker.entities.Tmocker;
import com.brian.TmocRanker.request.CreateSessionRequest;
import com.brian.TmocRanker.service.SessionResponse;
import com.brian.TmocRanker.service.SessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sessions")
public class SessionController {
    @Autowired
    private SessionServiceImpl sessionServiceImpl;

    @GetMapping("/get-all")
    public List<Session> viewSessionPage(Model model) {
        model.addAttribute("SessionList", sessionServiceImpl.getAllSession());
        List<Session> sessionList = sessionServiceImpl.getAllSession();
        List<SessionResponse> sessionResponseList = new ArrayList<>();
        sessionList.forEach(session -> sessionResponseList.add(new SessionResponse(session)));
        return sessionList;
    }

    @PostMapping("/create")
    public SessionResponse createSession(@Valid @RequestBody CreateSessionRequest createSessionRequest) {
        Session session = sessionServiceImpl.createSession(createSessionRequest);
        return new SessionResponse(session);
    }


}
