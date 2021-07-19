package com.example.demo.Controller;

import java.util.List;

import javax.validation.Valid;

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
import com.example.demo.Entity.Address;
import com.example.demo.service.AddResponse;
import com.example.demo.service.AddressService;

@RestController
@RequestMapping
public class AddressController {
	public static Logger logger = Logger.getLogger(AddressController.class);
	
	@Autowired
	AddressService addressService;

	@GetMapping("/address")
	public List<Address> getaddress()
	{
		return addressService.getAllAddress();
	}
	@PostMapping("/address/add") 
	public Address addaddress(@Valid @RequestBody Address address)
	{
		return addressService.addAllAddress(address);
	}
	@PutMapping("/address/update/{address_id}")    //Update books
	public Address updateBook(@PathVariable(value="address_id") int address_id, @RequestBody Address add)
	{
		Address existingAddress = addressService.getAddress(address_id);
		existingAddress.setHno(add.getHno());
		existingAddress.setStreet(add.getStreet());
		existingAddress.setCity(add.getCity());
		existingAddress.setState(add.getState());
		existingAddress.setPincode(add.getPincode());
		addressService.updateAllAddress(existingAddress);
		return existingAddress;
	}

	@DeleteMapping("/address/delete/{address_id}")   

	public AddResponse deleteAddress(@PathVariable(value = "address_id") int address_id)
	{
		logger.info("Address with address_id:"+" "+address_id+" "+"is deleted");
		return addressService.deleteAllAddress(address_id);    //Delete books
	}

}
