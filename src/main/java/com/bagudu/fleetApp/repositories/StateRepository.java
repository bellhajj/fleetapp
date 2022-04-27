package com.bagudu.fleetApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bagudu.fleetApp.models.State;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
