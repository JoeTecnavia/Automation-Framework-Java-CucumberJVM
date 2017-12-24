package com.simonkay.javaframework.configurations;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import datamodels.Order;

public class CucumberWorld {
	private static final Logger LOG = LogManager.getLogger(CucumberWorld.class);
	
	public HashMap<String, String> stepDefinitionState = new HashMap<String, String>();
	private HashMap<String, Order> orders = new HashMap<String, Order>();
	
	
	public HashMap<String, Order> getOrdersMap() {
		return orders;
	}
	
	public void addNewOrder(String orderAlias, Order order) {
		orders.put(orderAlias, order);
	}
	
	public Order getOrderByAlias(String orderAlias) {
		return orders.get(orderAlias);
	}
	
}
