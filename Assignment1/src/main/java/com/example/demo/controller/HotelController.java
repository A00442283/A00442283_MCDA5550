package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.*;
import com.example.demo.repository.*;


@RestController
public class HotelController {
	
	@Autowired
    private HotelRepository HotelRepo;
	
	@Autowired
    private HotelReservationRepository reservationRepository;

	@GetMapping("/hotelsList")
	public List<HotelModel> getListofHotels(Model model) {
		List<HotelModel> hotelList = HotelRepo.findAll();
		model.addAttribute(hotelList);
		return hotelList;
	}
	
	@PostMapping("/addHotels")
	@ResponseBody
	public String addHotels(@RequestBody HotelModel hotel) {
		HotelRepo.save(hotel);
		return "Added !";
	}
	
	@PostMapping("/reservation")
	@ResponseBody
	public HotelReservationModel reservationConfirmation(@RequestBody HotelReservationModel h) {
		
		return h;
	}
	
	@GetMapping("/reservationList")
	public String getListofReservations() {
		return "Reservations";
	}
	
	

}
