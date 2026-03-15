package visitorDesignPattern;

public class Chair implements Furniture {
	private String name;
	private String size;

	public Chair(String name, String size) {
		this.name = name;
		this.size = size;
		}

	@Override
	public String getName() {
		return name;
		}

	@Override
	public String getSize() { 
		return size; 
		}

	@Override
	public void accept(ShippingCalculator calculator) {
     calculator.visit(this);
		}
}