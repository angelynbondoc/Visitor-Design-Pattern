package visitorDesignPattern;

public interface Furniture {
	String getName();
	String getSize();   //small, medium, large
	void accept(ShippingCalculator calculator);
}
