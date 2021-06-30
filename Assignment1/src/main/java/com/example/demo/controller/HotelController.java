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
    private HotelRepository hotelRepo;
	
	@Autowired
    private HotelReservationRepository reservationRepo;
	
	@Autowired
    private ReservationRepository resRepo;

	@GetMapping("/hotelsList")
	public List<HotelModel> getListofHotels(Model model) {
		List<HotelModel> hotelList = hotelRepo.findAll();
		model.addAttribute(hotelList);
		return hotelList;
	}
	
	@PostMapping("/addHotels")
	@ResponseBody
	public String addHotels(@RequestBody HotelModel hotel) {
		hotelRepo.save(hotel);
		return "Added !";
	}
	
	@PostMapping("/reservation")
	@ResponseBody
	public String reservationConfirmation(@RequestBody HotelReservationModel h ) {
			
		HotelReservationModel a=reservationRepo.save(h);
		return "Reservation confirmation number - "+a.getReservation().getReservationID();
	}
	
	@GetMapping("/reservationList")
	public List<HotelReservationModel> getListofReservations(Model model) {
		List<HotelReservationModel> reservationList = reservationRepo.findAll(); 
	    //model.addAttribute(reservationList);
		//return reservationList;
	
		return reservationList;
	
	}
	
	@GetMapping("/reservations")
	public List<ReservationModel> getReservations(Model model) {
		List<ReservationModel> reservationList = resRepo.findAll(); 
	    //model.addAttribute(reservationList);
		//return reservationList;
		
		System.out.println(reservationList);
		return reservationList;
	
	}
	

}
