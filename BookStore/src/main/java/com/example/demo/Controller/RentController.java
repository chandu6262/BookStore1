package com.example.demo.Controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Rent;
import com.example.demo.service.AddResponse;
import com.example.demo.service.RentService;

@RestController
@RequestMapping
public class RentController {
	public static Logger logger = Logger.getLogger(RentController.class);
	
	@Autowired
	RentService restService;
	@GetMapping("/rent")
	public List<Rent> getrent()
	{
		return restService.getAllRents();
	}
	@PostMapping("/rent/add")
	public Rent addrent(@RequestBody Rent rent)
	{
		return restService.addAllRent(rent);
	}
	@PutMapping("/rent/update/{rental_id}")    //Update books
	public Rent updateRent(@PathVariable(value="rental_id") int rental_id, @RequestBody Rent rt)
	{
		Rent existingRent = restService.getRents(rental_id);
		existingRent.setIssued_date(rt.getIssued_date());
		existingRent.setReturned_date(rt.getReturned_date());
		existingRent.setAmount(rt.getAmount());
		restService.updateRents(existingRent);
		return existingRent;
	}

	@DeleteMapping("/rent/delete/{rental_id}")   

	public AddResponse deleteRent(@PathVariable(value = "rental_id") int rental_id)
	{
		logger.info("Rent details with rental_id:"+" "+rental_id+" "+"is deleted");
		return restService.deleteRents(rental_id);    //Delete books
	}
}
