package tqsorest.tests.unit;

import static org.junit.Assert.assertTrue;

import java.util.EnumMap;

import org.junit.Before;
import org.junit.Test;

import tqsorest.main.Dish.DishType;
import tqsorest.main.Ingredient;
import tqsorest.main.Ingredient.IngredientType;
import tqsorest.main.Kitchen;

public class KitchenTest {
	// Test member data
	public Kitchen kitchen;
	public EnumMap<Ingredient.IngredientType, Integer> kitchen_stock;
	
	@Before
	public void setUp() {
		kitchen_stock = new EnumMap<Ingredient.IngredientType, Integer>(Ingredient.IngredientType.class);
		kitchen_stock.put(IngredientType.MEAT, 1000);
		kitchen_stock.put(IngredientType.FISH, 1000);
		kitchen_stock.put(IngredientType.SALT, 1000);
		kitchen_stock.put(IngredientType.OLIVE, 1000);
		kitchen_stock.put(IngredientType.PEPPER, 1000);
		kitchen_stock.put(IngredientType.GARLIC, 1000);
		kitchen_stock.put(IngredientType.WATER, 1000);
		kitchen_stock.put(IngredientType.BEER, 1000);
		kitchen_stock.put(IngredientType.COKE, 1000);
		
		kitchen = new Kitchen(kitchen_stock);
	}
	
	@Test
	public void testCheckOrder() {
		assertTrue(kitchen.checkOrder(DishType.MEAT_WATER));
	}
}
