package visitorDesignPattern;

public class Table implements Furniture {
	private String name;
	private String size;
	private String material;  // "wood", "glass", "metal"
		
	public Table(String name, String size, String material) {
		this.name = name;
		this.size = size;
		this.material = material;
		}
		
	@Override
	public String getName() { 
		return name; 
		}
	
	@Override
	public String getSize() {
		return size; 
		}
	public String getMaterial() {
		return material; 
		}
		
	@Override
	public void accept(ShippingCalculator calculator) {
	calculator.visit(this);
		 }
}
