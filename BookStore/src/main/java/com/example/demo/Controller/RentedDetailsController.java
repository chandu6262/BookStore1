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

import com.example.demo.Entity.RentedBooksDetails;
import com.example.demo.service.AddResponse;
import com.example.demo.service.RentedBookDetailsService;

@RestController
@RequestMapping
public class RentedDetailsController {
	
	public static Logger logger = Logger.getLogger(RentedDetailsController.class);
	
	@Autowired
	RentedBookDetailsService rentDetails;


	@GetMapping("/RentedDetails")
	public List<RentedBooksDetails> getRentedBooksDetails()
	{
		return rentDetails.getAllRentedDetails();
	}
	@PostMapping("/RentedDetails/add")
	public RentedBooksDetails addRentedBooksDetails(@RequestBody RentedBooksDetails rented)
	{
		return rentDetails.addAllRentedDetails(rented);
	}
	@PutMapping("/RentedDetails/update/{rentedDetails_id}")    //Update books
	public RentedBooksDetails updateRentedDetail(@PathVariable(value="rentedDetails_id") int rentedDetails_id, @RequestBody RentedBooksDetails rbd)
	{
		RentedBooksDetails existingRentedDetails = rentDetails.getRentDetails(rentedDetails_id);
		existingRentedDetails.setIssued_quantity(rbd.getIssued_quantity());
		existingRentedDetails.setReturned_quantity(rbd.getRentedDetails_id());
		existingRentedDetails.setAmount(rbd.getAmount());
		rentDetails.updateAllRentedDetails(existingRentedDetails);
		return existingRentedDetails;
	}

	@DeleteMapping("/RentedDetails/delete/{rentedDetails_id}")   

	public AddResponse deleteRentedDetails(@PathVariable(value = "rentedDetails_id") int rentedDetails_id)
	{
		logger.info("Rented book details with rented details_id:"+" "+rentedDetails_id+" "+"is deleted");
		return rentDetails.deleteAllRentedDetails(rentedDetails_id);    //Delete books
	}

}
