package com.example.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Publisher;
import com.example.demo.Exception.PublisherNotFoundException;
import com.example.demo.Respository.PublisherRepository;

@Component
@Service
public class PublisherService {
	public static Logger logger = Logger.getLogger(PublisherService.class);

	@Autowired
	PublisherRepository publisherRepo;

	public List<Publisher> getAllPublishers()   //Get publisher details
	{
		return publisherRepo.findAll();
	}
	public Publisher getPublishers(int publisher_id)
	{
		List<Publisher> publisher =publisherRepo.findAll();
		logger.info("Checking condition");       //logging   
		for(Publisher pb:publisher)
		{
			if(pb.getPublisher_id()!=publisher_id) {
				logger.info("Exception occured");    //logging
				throw new PublisherNotFoundException("Invalid publisher id:"+" "+publisher_id);	// find by id
			}
			else { 
				logger.info("Publisher with publisher id:"+" "+publisher_id+" "+"is updated succesfully");  //logging
				return publisherRepo.findById(publisher_id).get(); }
		}
		return null;
	}
	public Publisher addAllPublisher(Publisher publisher)
	{ 
		publisherRepo.save(publisher);         //Add publisher details
		return publisher;
	}
	public Publisher updatePublishers(Publisher p)
	{

		publisherRepo.save(p);     //update
		return p;

	}

	public AddResponse deletePublsihers(int publisher_id)
	{
		List<Publisher> publisher =publisherRepo.findAll();
		logger.info("Checking condition");       //logging   
		for(Publisher pb:publisher)
		{
			if(pb.getPublisher_id()!=publisher_id) {
				logger.info("Exception occured");    //logging
				throw new PublisherNotFoundException("Invalid publisher id:"+" "+publisher_id);	// find by id
			}
			else { 
				logger.info("Publisher with publisher id:"+" "+publisher_id+" "+"is updated succesfully");  //logging
				publisherRepo.deleteById(publisher_id);    //delete
				AddResponse res =  new AddResponse();
				res.setId(publisher_id);
				res.setMsge("Publisher deleted succesfully");
				return res; }
		}
		return null;
	}

}
