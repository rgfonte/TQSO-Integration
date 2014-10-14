package tqsorest.tests.unit;

import static org.junit.Assert.*;

import org.junit.Test;

import tqsorest.main.Restaurant;

public class RestaurantTest {

	@Test
	public void testRestaurant(){
		Restaurant restaurant = new Restaurant();
		assertEquals("A test for HelloString", "Hello", restaurant.printHello());
	}

}