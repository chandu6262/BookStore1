package com.example.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Rent;
import com.example.demo.Exception.RentNotFoundException;
import com.example.demo.Respository.RentRepository;

@Component
@Service
public class RentService {
	public static Logger logger = Logger.getLogger(RentService.class);
	@Autowired
	RentRepository rentRepo;

	public List<Rent> getAllRents()
	{
		return rentRepo.findAll();
	}
	public Rent getRents(int rental_id)
	{
		List<Rent> rent =rentRepo.findAll();
		logger.info("Checking condition");          //logging
		for(Rent rt:rent)
		{
			logger.info("Exception occured");       //logging
			if(rt.getRental_id()!=rental_id) {
				logger.info("Exception occured");   //logging
				throw new RentNotFoundException("Invalid rental id:"+" "+rental_id);	
			}
			else { 
				logger.info("Rent with rent id:"+" "+rental_id+" "+"is updated succesfully");  //logging
				return rentRepo.findById(rental_id).get(); }
		}                                     // find by id
		return null;
	}
	public Rent addAllRent(Rent rent)
	{
		rentRepo.save(rent);          // Add rent details
		return rent;
	}
	public Rent updateRents(Rent r)
	{
		rentRepo.save(r);     //update
		return r;

	}

	public AddResponse deleteRents(int rental_id)
	{
		List<Rent> rent =rentRepo.findAll();
		logger.info("Checking condition");          //logging
		for(Rent rt:rent)
		{
			logger.info("Exception occured");       //logging
			if(rt.getRental_id()!=rental_id) {
				logger.info("Exception occured");   //logging
				throw new RentNotFoundException("Invalid rental id:"+" "+rental_id);	
			}
			else { 
				logger.info("Rent with rent id:"+" "+rental_id+" "+"is updated succesfully");  //logging
				rentRepo.deleteById(rental_id);    //delete
				AddResponse res =  new AddResponse();
				res.setId(rental_id);
				res.setMsge("Rent details deleted succesfully");
				return res; }
		}
		return null;
	}

}
