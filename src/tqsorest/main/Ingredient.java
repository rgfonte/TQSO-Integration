package tqsorest.main;

public class Ingredient {
	// Class Members
	public static enum IngredientType {
		MEAT, FISH, SALT, OLIVE, PEPPER, GARLIC, WATER, BEER, COKE
	};
	
	private static double[] m_price_table = {3.0, 4.0, 0.1, 0.3, 0.1, 0.1, 1.2, 1, 1.2};
	
	private double m_price;
	private IngredientType m_type;
	
	// Methods
	public Ingredient(IngredientType type) {
		m_type = type;
		m_price = m_price_table[m_type.ordinal()];
	}

	public double get_price() {
		return m_price;
	}

	public void set_price(double m_price) {
		this.m_price = m_price;
	}

	public IngredientType get_type() {
		return m_type;
	}

	public void set_type(IngredientType m_type) {
		this.m_type = m_type;
	}
	
	public static double[] get_priceTable() {
		return m_price_table;
	}
	
	public static void set_priceTable(double[] priceTable) {
		m_price_table = priceTable;
	}
}
