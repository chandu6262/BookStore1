package com.example.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.RentedBooksDetails;
import com.example.demo.Exception.RentedBookDetailsNotFoundExp;
import com.example.demo.Respository.RentedBooksDetailsRepository;

@Component
@Service
public class RentedBookDetailsService {
	public static Logger logger = Logger.getLogger(RentedBookDetailsService.class);
	@Autowired
	RentedBooksDetailsRepository rentedBooksDetailsRepo;


	public List<RentedBooksDetails> getAllRentedDetails()
	{
		return rentedBooksDetailsRepo.findAll();
	}
	public RentedBooksDetails getRentDetails(int rentedDetails_id)
	{
		List<RentedBooksDetails> rbd =rentedBooksDetailsRepo.findAll();
		logger.info("Checking condition");      //logging 
		for(RentedBooksDetails rb:rbd)
		{
			if(rb.getRentedDetails_id()!=rentedDetails_id) {
				logger.info("Exception occured");    //logging
				throw new RentedBookDetailsNotFoundExp("Invalid id:"+" "+rentedDetails_id);	// find by id
			}
			else { 
				logger.info("Rented book details with details id:"+" "+rentedDetails_id+" "+"is updated succesfully");  //logging
				return rentedBooksDetailsRepo.findById(rentedDetails_id).get();}
		}
		return null;
	}
	public RentedBooksDetails addAllRentedDetails(RentedBooksDetails rentedDetails)
	{
		rentedBooksDetailsRepo.save(rentedDetails);   //Add details
		return rentedDetails;
	}
	public RentedBooksDetails updateAllRentedDetails(RentedBooksDetails rd)
	{

		rentedBooksDetailsRepo.save(rd);     //update
		return rd;

	}	

	public AddResponse deleteAllRentedDetails(int rentedDetails_id)
	{
		List<RentedBooksDetails> rbd =rentedBooksDetailsRepo.findAll();
		logger.info("Checking condition");      //logging 
		for(RentedBooksDetails rb:rbd)
		{
			if(rb.getRentedDetails_id()!=rentedDetails_id) {
				logger.info("Exception occured");    //logging
				throw new RentedBookDetailsNotFoundExp("Invalid id:"+" "+rentedDetails_id);	// find by id
			}
			else { 
				logger.info("Rented book details with details id:"+" "+rentedDetails_id+" "+"is updated succesfully");  //logging
				rentedBooksDetailsRepo.deleteById(rentedDetails_id);    //delete
				AddResponse res =  new AddResponse();
				res.setId(rentedDetails_id);
				res.setMsge("Rented Books details deleted succesfully");
				return res; 
			}
		}
		return null;
	}

}
