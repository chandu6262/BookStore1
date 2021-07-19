package com.example.demo.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Address;
import com.example.demo.Exception.AddressNotFoundException;
import com.example.demo.Respository.AddressRepository;

@Component
@Service
public class AddressService {
	public static Logger logger = Logger.getLogger(AddressService.class);

	@Autowired
	AddressRepository addressRepo;

	public List<Address> getAllAddress()
	{
		return addressRepo.findAll();
	}
	public Address getAddress(int address_id)
	{
		List<Address> address =addressRepo.findAll();
		logger.info("Checking condition");       //logging
		for(Address adds:address)
		{
			if(adds.getAddress_id()!=address_id) {
				logger.info("Exception occured");    //logging
				throw new AddressNotFoundException("Invalid address id :" +" "+ address_id);	// find by id
			}
			else {
				logger.info("Address with address id:"+" "+address_id+" "+"is updated succesfully");  //logging
				return addressRepo.findById(address_id).get(); }
		}
		return null;
	}
	public Address addAllAddress(Address address)
	{ 
		addressRepo.save(address);          //Add address
		return address;
	}
	public Address updateAllAddress(Address ad)
	{

		addressRepo.save(ad);     //update
		return ad;}


	public AddResponse deleteAllAddress(int address_id)
	{

		List<Address> address =addressRepo.findAll();
		logger.info("Checking condition");       //logging
		for(Address adds:address)
		{
			if(adds.getAddress_id()!=address_id) {
				logger.info("Exception occured");    //logging
				throw new AddressNotFoundException("Invalid address id :" +" "+ address_id);	// find by id
			}
			else {
				logger.info("Address with address id:"+" "+address_id+" "+"is updated succesfully");  //logging
				addressRepo.deleteById(address_id);    //delete
				AddResponse res =  new AddResponse();
				res.setId(address_id);
				res.setMsge("Address deleted succesfully");
				return res; }
		}
		return null;
	}
}
