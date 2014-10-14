package tqsorest.main;

import java.util.ArrayList;


public class Dish {
	// Class Members
	public static enum DishType {
		MEAT_WATER, MEAT_BEER, MEAT_COKE, FISH_WATER, FISH_BEER, FISH_COKE
	};
	
	//  Menu Ingredients Order: MEAT, FISH, SALT, OLIVE, PEPPER, GARLIC, WATER, BEER, COKE => values of array between true or false
	private static boolean[][] menu = new boolean[][] {
		{true, false, true, true, true, false, true, false, false}, // MEAT WATER
		{true, false, true, true, true, false, false, true, false}, // MEAT BEER
		{true, false, true, true, true, false, false, false, true}, // MEAT COKE
		{false, true, true, true, false, true, true, false ,false}, // FISH WATER
		{false, true, true, true, false, true, false, true, false}, // FISH BEER
		{false, true, true, true, false, true, false, false, true}, // FISH COKE
	};
	
	private double m_price;
	private DishType m_type;
	
	// Methods
	public Dish(DishType type) {
		m_type = type;
		calculatePrice();
	}

	public double get_price() {
		return m_price;
	}

	public void set_price(double m_price) {
		this.m_price = m_price;
	}

	public DishType get_type() {
		return m_type;
	}

	public void set_type(DishType m_type) {
		this.m_type = m_type;
	}
	
	public void calculatePrice() {
		boolean[] dishIngredients = menu[m_type.ordinal()];
		for (int i=0; i<dishIngredients.length; i++) {
			if ( dishIngredients[i] ) {
				m_price += Ingredient.get_priceTable()[i];
			}
		}
	}
	
	public ArrayList<Ingredient.IngredientType> getDishIngredientsType() {
		return getDishIngredientsForAGivenType(m_type);
	}
	
	public static ArrayList<Ingredient.IngredientType> getDishIngredientsForAGivenType(DishType type) {
		ArrayList<Ingredient.IngredientType> dishIngredientsTypeToReturn = new ArrayList<Ingredient.IngredientType>();
		for(int i=0; i<menu[type.ordinal()].length; i++) {
			if ( menu[type.ordinal()][i] ) {
				
				for (Ingredient.IngredientType ingredientType : Ingredient.IngredientType.values()) {
					if (ingredientType.ordinal() == i) {
						dishIngredientsTypeToReturn.add(ingredientType);
					}
				}
			}
		}
		return dishIngredientsTypeToReturn;
	}
	
	@Override
	public boolean equals(Object other){
	    if (other == null) return false;
	    if (other == this) return true;
	    
	    if (this.m_type == ((Dish)other).get_type())
	    	return true;
	    
	    return false;
	}
}
