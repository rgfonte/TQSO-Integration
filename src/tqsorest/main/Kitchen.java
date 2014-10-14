package tqsorest.main;

import java.util.ArrayList;
import java.util.EnumMap;

import tqsorest.main.Dish.DishType;

public class Kitchen {
	// Class Members
	private static EnumMap<Ingredient.IngredientType, Integer> m_stock = new EnumMap<Ingredient.IngredientType, Integer>(Ingredient.IngredientType.class);
	
	// Methods
	public Kitchen(EnumMap<Ingredient.IngredientType, Integer> stock) {
		m_stock = stock;
	}

	public static EnumMap<Ingredient.IngredientType, Integer> get_stock() {
		return m_stock;
	}

	public static void set_stock(EnumMap<Ingredient.IngredientType, Integer> stock) {
		Kitchen.m_stock = stock;
	}
	
	public boolean checkOrder(DishType dishType) {
		ArrayList<Ingredient.IngredientType> ingredients = Dish.getDishIngredientsForAGivenType(dishType);
		for(int i=0; i<ingredients.size(); i++) {
			if ( m_stock.get(ingredients.get(i)) <= 0 ) {
				return false;
			}
		}
		return true;
	}
	
	public ArrayList<Dish> makeOrder(DishType dishType, int quantity) {
		ArrayList<Dish> dishesToReturn = new ArrayList<Dish>();
		checkOrder(dishType);
		dishesToReturn.add(new Dish(DishType.MEAT_WATER));
		return dishesToReturn;
	}
}
