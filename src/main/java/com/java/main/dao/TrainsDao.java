package com.java.main.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.java.main.entity.Trains;

@Component
public interface TrainsDao extends JpaRepository<Trains, Integer>{

	List<Trains> findByTrainNo(Long trainNo);
	
	@Query("SELECT DISTINCT t.source FROM Trains t")
	List<String> findDistinctBySource();
	
	@Query("SELECT DISTINCT t.destination FROM Trains t")
	List<String> findDistinctByDestination();

	@Query("SELECT t FROM Trains t WHERE t.source=?1 and t.destination=?2 and date=?3")
	List<Trains> findBySearchTrains(String source, String destination, Date date);
	
}
