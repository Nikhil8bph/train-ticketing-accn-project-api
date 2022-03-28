package com.java.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.java.main.entity.Ticket;

@Component
public interface TicketDao extends JpaRepository<Ticket, Integer>{

}
