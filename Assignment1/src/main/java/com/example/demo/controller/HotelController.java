package com.example.demo.controller;

import java.util.*;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


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
	
	private String removeQuotesAndUnescape(String uncleanJson) {
	    String noQuotes = uncleanJson.replaceAll("^\"|\"$", "");

	    return StringEscapeUtils.unescapeJava(noQuotes);
	}
	
	
	@PostMapping(value="/reservation")
	@ResponseBody
	public String reservationConfirmation(@RequestBody String h ) {
			
		//Gson gson = new Gson();
		Gson gson=new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
		System.out.println(removeQuotesAndUnescape(h));
		HotelReservationModel hotelData = gson.fromJson(removeQuotesAndUnescape(h), HotelReservationModel.class);
		System.out.println(hotelData);
		HotelReservationModel a=reservationRepo.save(hotelData);
		
		ReservationResponse r = new ReservationResponse(a.getReservation().getReservationID());

		return gson.toJson(r);
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
