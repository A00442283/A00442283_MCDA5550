package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.ReservationModel;

public interface ReservationRepository extends JpaRepository<ReservationModel,Integer> {

}
