package tqsorest.tests.integration;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.EnumMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import tqsorest.main.Dish.DishType;
import tqsorest.main.Ingredient;
import tqsorest.main.Ingredient.IngredientType;
import tqsorest.main.Dish;
import tqsorest.main.Kitchen;
import tqsorest.main.NoIngredientsException;

public class IntegrationTest2 {
	// Test member data
	public Kitchen kitchen;
	public EnumMap<Ingredient.IngredientType, Integer> kitchen_stock;
	
	@Rule
	 public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
		insertIngredientsOnKitchenStock(0);
		kitchen = new Kitchen(kitchen_stock);
	}
	
	public void insertIngredientsOnKitchenStock(int ingredientsNumber) {
		kitchen_stock = new EnumMap<Ingredient.IngredientType, Integer>(Ingredient.IngredientType.class);
		kitchen_stock.put(IngredientType.MEAT, ingredientsNumber);
		kitchen_stock.put(IngredientType.FISH, ingredientsNumber);
		kitchen_stock.put(IngredientType.SALT, ingredientsNumber);
		kitchen_stock.put(IngredientType.OLIVE, ingredientsNumber);
		kitchen_stock.put(IngredientType.PEPPER, ingredientsNumber);
		kitchen_stock.put(IngredientType.GARLIC, ingredientsNumber);
		kitchen_stock.put(IngredientType.WATER, ingredientsNumber);
		kitchen_stock.put(IngredientType.BEER, ingredientsNumber);
		kitchen_stock.put(IngredientType.COKE, ingredientsNumber);
		Kitchen.set_stock(kitchen_stock);
	}

	@Test
	public void testKitchen1() {
		exception.expect(NoIngredientsException.class);
	    kitchen.makeOrder(DishType.MEAT_WATER, 1);
	}
	
	@Test
	public void testKitchen2() {
		insertIngredientsOnKitchenStock(100);
		ArrayList<Dish> expectedDishesOfOrder = new ArrayList<Dish>();
		ArrayList<Dish> returnedDishesOfOrder;
		expectedDishesOfOrder.add(new Dish(DishType.MEAT_WATER));
		returnedDishesOfOrder = kitchen.makeOrder(DishType.MEAT_WATER, 1);
		
		EnumMap<Ingredient.IngredientType, Integer> expectedKitchenStock = new EnumMap<Ingredient.IngredientType, Integer>(Ingredient.IngredientType.class);
		kitchen_stock.put(IngredientType.MEAT, 99);
		kitchen_stock.put(IngredientType.FISH, 100);
		kitchen_stock.put(IngredientType.SALT, 99);
		kitchen_stock.put(IngredientType.OLIVE, 99);
		kitchen_stock.put(IngredientType.PEPPER, 99);
		kitchen_stock.put(IngredientType.GARLIC, 100);
		kitchen_stock.put(IngredientType.WATER, 99);
		kitchen_stock.put(IngredientType.BEER, 100);
		kitchen_stock.put(IngredientType.COKE, 100);
		
		EnumMap<Ingredient.IngredientType, Integer> actualKitchenStock = Kitchen.get_stock();
		
		assertArrayEquals(expectedKitchenStock.values().toArray(), actualKitchenStock.values().toArray());
		assertArrayEquals(expectedDishesOfOrder.toArray(), returnedDishesOfOrder.toArray());
	}
}