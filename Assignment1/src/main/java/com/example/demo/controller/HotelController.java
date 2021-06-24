package com.example.demo.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.HotelReservationModel;


@RestController
public class HotelController {
	

	@GetMapping("/hotelsList")
	public String getListofHotels() {
		return "List of Hotels";
	}
	
	@PostMapping("/reservation")
	@ResponseBody
	public HotelReservationModel reservationConfirmation(@RequestBody HotelReservationModel h) {
		
		return h;
	}
	

}
