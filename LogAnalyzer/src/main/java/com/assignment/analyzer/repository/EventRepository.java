package com.assignment.analyzer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.analyzer.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, String>{

}
