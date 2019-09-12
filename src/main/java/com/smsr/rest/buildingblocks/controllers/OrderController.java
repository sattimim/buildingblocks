package com.smsr.rest.buildingblocks.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smsr.rest.buildingblocks.entities.Order;
import com.smsr.rest.buildingblocks.entities.User;
import com.smsr.rest.buildingblocks.exceptions.OrderNotFoundException;
import com.smsr.rest.buildingblocks.exceptions.UserNotFoundException;
import com.smsr.rest.buildingblocks.repositories.OrderRepository;
import com.smsr.rest.buildingblocks.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class OrderController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/{userid}/orders")
	public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {
		
		Optional<User> userOptional = userRepository.findById(userid);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		} else {
			return userOptional.get().getOrders();
		}
	}
	
	@PostMapping("{userid}/orders")
	public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {
		
		Optional<User> userOptional = userRepository.findById(userid);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		} else {
			User user = userOptional.get();
			order.setUser(user);
			return orderRepository.save(order);
		}
	}
	
	@GetMapping("/{userid}/orders/{orderid}")
	public Optional<Order> getOrderByOrderId(@PathVariable Long userid, @PathVariable Long orderid) throws UserNotFoundException, OrderNotFoundException {
		
		Optional<User> userOptional = userRepository.findById(userid);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		} else {
			Optional<Order> optionalOrder = orderRepository.findById(orderid);
			 
			if(optionalOrder.isPresent()) {
				return optionalOrder;
			} else {
				throw new OrderNotFoundException("OrderId Not Found");
			}
		}
	}
}
