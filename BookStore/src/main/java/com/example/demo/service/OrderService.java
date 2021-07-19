package com.example.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Orders;
import com.example.demo.Exception.OrderNotFoundException;
import com.example.demo.Respository.OrdersRepository;

@Component
@Service
public class OrderService {
	public static Logger logger = Logger.getLogger(OrderService.class);
	@Autowired
	OrdersRepository ordersRepo;

	public List<Orders> getAllOrders()
	{
		return ordersRepo.findAll();
	}
	public Orders getOrders(int order_id)
	{
		List<Orders> order =ordersRepo.findAll();
		logger.info("Checking condition");       //logging  
		for(Orders or:order)
		{
			if(or.getOrder_id()!=order_id) {
				logger.info("Exception occured");    //logging
				throw new OrderNotFoundException("Invalid oder id:" +" "+ order_id);	// find by id
			}
			else {
				logger.info("Order with order id:"+" "+order_id+" "+"is updated succesfully");  //logging
				return ordersRepo.findById(order_id).get();}
		}
		return null;
	}
	public Orders addAllOrders(Orders order)
	{
		ordersRepo.save(order);        //Add Order details
		return order;
	}
	public Orders updateOrders(Orders o)
	{

		ordersRepo.save(o);     //update
		return o;

	}

	public AddResponse deleteOrders(int order_id)
	{
		List<Orders> order =ordersRepo.findAll();
		logger.info("Checking condition");       //logging  
		for(Orders or:order)
		{
			if(or.getOrder_id()!=order_id) {
				logger.info("Exception occured");    //logging
				throw new OrderNotFoundException("Invalid oder id:" +" "+ order_id);	// find by id
			}
			else {
				logger.info("Order with order id:"+" "+order_id+" "+"is updated succesfully");  //logging
				ordersRepo.deleteById(order_id);    //delete
				AddResponse res =  new AddResponse();
				res.setId(order_id);
				res.setMsge("Order details deleted succesfully");
				return res; }
		}
		return null;
	}
}
