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

import com.example.demo.Entity.Orders;
import com.example.demo.service.AddResponse;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping
public class OrderController {
	public static Logger logger = Logger.getLogger(OrderController.class);
	
	@Autowired
	OrderService orderService;

	@GetMapping("/orders")
	public List<Orders> getorder()
	{
		return orderService.getAllOrders();
	}
	@PostMapping("/orders/add")
	public Orders addorder(@RequestBody Orders order)
	{
		return orderService.addAllOrders(order);
	}
	@PutMapping("/orders/update/{order_id}")    //Update books
	public Orders updateOrder(@PathVariable(value="order_id") int order_id, @RequestBody Orders od)
	{
		Orders existingOrders = orderService.getOrders(order_id);
		existingOrders.setQuantity(od.getQuantity());
		existingOrders.setDate_of_order(od.getDate_of_order());
		existingOrders.setTotal_price(od.getTotal_price());
		orderService.updateOrders(existingOrders);
		return existingOrders;
	}

	@DeleteMapping("/orders/delete/{order_id}")   

	public AddResponse deleteOrder(@PathVariable(value = "order_id") int order_id)
	{
		logger.info("Order with order_id:"+" "+order_id+" "+"is deleted");
		return orderService.deleteOrders(order_id);    //Delete books
	}

}
