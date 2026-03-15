package visitorDesignPattern;

public class Sofa implements Furniture {
	private String name;
	private String size;
	private double distanceKm;

	public Sofa(String name, String size, double distanceKm) {
		this.name = name;
		this.size = size;
		this.distanceKm = distanceKm;
		}

	 @Override
	 public String getName() {
		 return name;
		 }
	
	 @Override
	 public String getSize() {
		 return size;
		 }
	
	 public double getDistanceKm() {
		 return distanceKm;
		 }
	
	 @Override
	 public void accept(ShippingCalculator calculator) {
	     calculator.visit(this);
	     }
}
