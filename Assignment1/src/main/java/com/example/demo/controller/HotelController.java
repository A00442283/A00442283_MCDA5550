package com.example.demo.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;


@RestController
public class HotelController {
	

	@GetMapping("/hotelsList")
	public String getListofHotels() {
		return "List of Hotels";
	}
	
	@PostMapping("/reservation")
	@ResponseBody
	public String reservationConfirmation(@RequestBody String h ) {
		return h;
	}
	

}
