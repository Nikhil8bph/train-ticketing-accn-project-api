package com.java.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.dao.TrainsDao;
import com.java.main.entity.Trains;
import com.java.main.message.ResponseMessage;
import com.java.main.message.ResponseMessageList;

@RestController
@CrossOrigin
public class TrainController {

	@Autowired
	TrainsDao trainsDao;
	
	@GetMapping("/trains")
	public List<Trains> getTrains() {
		return trainsDao.findAll();
	}
	
	@PostMapping("/trains")
	public ResponseMessage postTrains(@RequestBody Trains train) {
		if(trainsDao.findByTrainNo(train.getTrainNo()).size()==0){
			return new ResponseMessage("Train Registered with id : "+trainsDao.save(train).getId());
		}
		return new ResponseMessage("Train already present");
	}
	
	
	@PostMapping("/trainlist")
	public ResponseMessage postTrainsList(@RequestBody List<Trains> train) {
		for(Trains tr:train) {
			if(trainsDao.findByTrainNo(tr.getTrainNo()).size()!=0){
				train.remove(tr);
			}
		}		
		if(train.size()!=0){
			return new ResponseMessage("Train Registered with id : "+trainsDao.saveAll(train).toString());
		}
		return new ResponseMessage("Train already present");
	}
	
	@PostMapping("/trainsearch")
	public ResponseEntity<List<Trains>> trainSearch(@RequestBody Trains train) {
		return ResponseEntity.ok(trainsDao.findBySearchTrains(train.getSource(),train.getDestination(),train.getDate()));
	}
	
	@DeleteMapping("/trains/{id}")
	public ResponseMessage getTrains(@PathVariable("id") int id) {
		try {
			trainsDao.deleteById(id);
			return new ResponseMessage("Successully Deleted");
		} catch (Exception e) {
			return new ResponseMessage("Not Deleted");
		} 
	}
	
	@GetMapping("/trainsources")
	public ResponseMessageList getTrainSources() {
		return new ResponseMessageList(trainsDao.findDistinctBySource());
	}
	
	@GetMapping("/traindestination")
	public ResponseMessageList getTrainDestination() {
		return new ResponseMessageList(trainsDao.findDistinctByDestination());
	}
}
