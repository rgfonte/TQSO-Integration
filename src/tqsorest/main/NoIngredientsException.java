package tqsorest.main;

public class NoIngredientsException extends Exception {
	private static final long serialVersionUID = 2533564311395410444L;
	
	public NoIngredientsException() { super(); }
	public NoIngredientsException(String message) { super(message); }
	public NoIngredientsException(String message, Throwable cause) { super(message, cause); }
	public NoIngredientsException(Throwable cause) { super(cause); }
}
