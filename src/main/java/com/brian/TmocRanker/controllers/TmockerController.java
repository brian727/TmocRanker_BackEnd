package com.brian.TmocRanker.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.brian.TmocRanker.entities.Tmocker;
import com.brian.TmocRanker.request.CreateTmockerRequest;
import com.brian.TmocRanker.request.UpdateTmockerRequest;
import com.brian.TmocRanker.service.TmockerResponse;
import com.brian.TmocRanker.service.TmockerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tmockers")
public class TmockerController {

	@Autowired
	private TmockerServiceImpl tmockerServiceImpl;

	@GetMapping("/get-all")
	public List<TmockerResponse> getAllTmockers(Model model) {
		List<Tmocker> tmockerList = tmockerServiceImpl.getAllTmocker();
		List<TmockerResponse> tmockerResponseList = new ArrayList<>();
		tmockerList.forEach(tmocker -> tmockerResponseList.add(new TmockerResponse(tmocker)));
		model.addAttribute("tmocker", tmockerResponseList);
		return tmockerResponseList;
	}

	@GetMapping("/get-by-id/{tmocker_id}")
	public Optional<Tmocker> findByTmocker_Id(@PathVariable("tmocker_id") long tmocker_id) {
		return Optional.ofNullable(tmockerServiceImpl.getTmockerById(tmocker_id));
	}

	@GetMapping("/get-by-email/{email}")
	public List<Tmocker> findByEmail(@PathVariable("email") String email) {
		return tmockerServiceImpl.findByEmail(email);
	}

	@PutMapping("/update")
	public TmockerResponse updateTmocker(@Valid @RequestBody UpdateTmockerRequest updateTmockerRequest) {
		Tmocker tmocker = tmockerServiceImpl.updateTmocker(updateTmockerRequest);
		return new TmockerResponse(tmocker);
	}

	@PostMapping("/create")
	public TmockerResponse createTmocker(@Valid @RequestBody CreateTmockerRequest createTmockerRequest) {
		Tmocker tmocker = tmockerServiceImpl.createTmocker(createTmockerRequest);
		return new TmockerResponse(tmocker);
	}


}






////// USES @PathVariable
//	@DeleteMapping("/delete/{tmocker_id}")
//	public String deleteTmocker (@PathVariable("tmocker_id") long id) {
//		return tmockerService.deleteTmocker(id);
//	}
//}

// ########################################################
////// USES @RequestParam
//	@DeleteMapping("/delete")
//	public String deleteTmocker(@RequestParam long id){
//		return tmockerService.deleteTmocker(id);
//	}
// ########################################################

//	@Value("${app.name}")
//	private String appName;
