package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.*;

public interface GuestRepository extends JpaRepository<GuestModel,Integer> {

}
