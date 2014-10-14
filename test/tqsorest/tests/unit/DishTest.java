package tqsorest.tests.unit;

import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


import tqsorest.main.Dish;
import tqsorest.main.Dish.DishType;
import tqsorest.main.Ingredient.IngredientType;
import tqsorest.main.Ingredient;

public class DishTest {
	// Test member data
	public Dish dish;
	
	@Before
	public void setUp() {
		dish = new Dish(DishType.MEAT_WATER);
	}
	
	@Test
	public void testCalculatePrice() {
		assertEquals("Test Pick A Client From Waiting Room Method", 4.7, dish.get_price(), 0.0001);
	}
	
	@Test
	public void testGetDishIngredientsForAGivenType() {
		ArrayList<Ingredient.IngredientType> expectedIngredients = new ArrayList<Ingredient.IngredientType>();
		expectedIngredients.add(IngredientType.MEAT);
		expectedIngredients.add(IngredientType.SALT);
		expectedIngredients.add(IngredientType.OLIVE);
		expectedIngredients.add(IngredientType.PEPPER);
		expectedIngredients.add(IngredientType.WATER);
		
		assertArrayEquals(expectedIngredients.toArray(), dish.getDishIngredientsType().toArray());
	}
}


