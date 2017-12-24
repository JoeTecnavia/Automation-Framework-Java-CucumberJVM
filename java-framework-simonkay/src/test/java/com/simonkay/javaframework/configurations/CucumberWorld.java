package com.simonkay.javaframework.configurations;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.simonkay.javaframework.datamodels.Order;

public class CucumberWorld {
	private static final Logger LOG = LogManager.getLogger(CucumberWorld.class);
	
	public HashMap<String, String> stepDefinitionState = new HashMap<String, String>();
	private HashMap<String, Object> orders = new HashMap<String, Object>();
	
	
	public HashMap<String, Object> getOrdersMap() {
		return orders;
	}
	
	public void addNewOrder(String orderAlias, Order order) {
		LOG.debug("Adding new order to cucumber world with alias: " + orderAlias + ". Order: " + order.toString());
		orders.put(orderAlias, order);
	}
	
	public Order getOrderByAlias(String orderAlias) {
		LOG.debug("Retrieving order from cucumber world with alias: " + orderAlias);
		if (orders.get(orderAlias) instanceof Order) {
			LOG.debug("Alias is infact an Order, casting from Obj to Order");
			return (Order) orders.get(orderAlias);
		}
		LOG.fatal("ATTEMPTING TO RETRIEVE AN INCORRECT OBJECT TYPE FROM THE WORLD, IT WAS NOT AN INSTANCE OF ORDER, RETURNING NULL");
		return null;		
	}
	
}
