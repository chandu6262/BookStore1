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

import com.example.demo.Entity.Publisher;
import com.example.demo.service.AddResponse;
import com.example.demo.service.PublisherService;

@RestController
@RequestMapping
public class PublisherController {
	public static Logger logger = Logger.getLogger(PublisherController.class);
	
	@Autowired
	PublisherService publisherService;


	@GetMapping("/publishers")
	public List<Publisher> getpublishers()
	{
		return publisherService.getAllPublishers();
	}

	@PostMapping("/publishers/add")
	public Publisher addpublishers(@RequestBody Publisher publisher)
	{
		return publisherService.addAllPublisher(publisher);
	}

	@PutMapping("/publishers/update/{publisher_id}")    //Update books
	public Publisher updateBook(@PathVariable(value="publisher_id") int publisher_id, @RequestBody Publisher pb)
	{
		Publisher existingPublisher = publisherService.getPublishers(publisher_id);
		existingPublisher.setPublisher_name(pb.getPublisher_name());
		existingPublisher.setDate_of_birth(pb.getDate_of_birth());
		existingPublisher.setDate_of_publishing(pb.getDate_of_birth());
		publisherService.updatePublishers(existingPublisher);
		return existingPublisher;
	}

	@DeleteMapping("/publishers/delete/{publisher_id}")   

	public AddResponse deletePublisher(@PathVariable(value = "publisher_id") int publisher_id)
	{
		logger.info("Publisher with publisher_id:"+" "+publisher_id+" "+"is deleted");
		return publisherService.deletePublsihers(publisher_id);    //Delete books
	}


}
