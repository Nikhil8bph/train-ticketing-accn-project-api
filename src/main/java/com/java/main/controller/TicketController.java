package com.java.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.dao.TicketDao;
import com.java.main.entity.Ticket;



@RestController
@CrossOrigin
public class TicketController {
	final float price = 1000.00f;
	@Autowired
	TicketDao ticketDao;
	
	@GetMapping("/tickets")
	public List<Ticket> getTickets() {
		return ticketDao.findAll();
	}
	
	@PostMapping("/tickets")
	public List<Ticket> postTickets(@RequestBody List<Ticket> tickets) {
		for(Ticket ticket:tickets){
			if(ticket.getAge()>=60 && ticket.getAge()<120) {
				ticket.setPrice(price);
				ticket.setDiscount(20);
				ticket.setFinalPrice((float)(ticket.getPrice() - ticket.getPrice()*ticket.getDiscount()/100));
			}
			else if(ticket.getAge()<=5 && ticket.getAge()>0) {
				ticket.setPrice(price);
				ticket.setDiscount(100);
				ticket.setFinalPrice((float)(ticket.getPrice() - ticket.getPrice()*ticket.getDiscount()/100));
			}
			else if(ticket.getAge()>5 && ticket.getAge()<60){
				ticket.setPrice(price);
				ticket.setDiscount(0);
				ticket.setFinalPrice((float)(ticket.getPrice() - ticket.getPrice()*ticket.getDiscount()/100));
			}
		}
		return ticketDao.saveAll(tickets);
	}
	
	@DeleteMapping("/tickets/{id}")
	public String getTickets(@PathVariable("id") int id) {
		try {
			ticketDao.deleteById(id);
			return "Successully Deleted";
		} catch (Exception e) {
			return "Not Deleted";
		} 
	}
}
