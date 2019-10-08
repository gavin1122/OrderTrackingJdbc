package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dto.Order;

@Path("/orders")
public class OrderResource {

	OrderService service =  new OrderServiceImpl();
	
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})

	public List<Order> getOrders()
	{
		return service.getAllOrders();
		
		
	}
	
	
	@Path("/{id}")
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})

	public Order getOrder(@PathParam("id")int id)
	{
		return service.getOrderById(id);
		
		}
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})

	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public Order addP(Order o)
    {
	   int newid =  service.getMaxOrderid()+1;
	   o.setId(newid);
		service.addOrder(o);
	return o;
	
		
    }
    
	
	
	
	
	
	
	
	
	
}
