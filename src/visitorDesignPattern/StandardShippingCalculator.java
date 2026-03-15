package visitorDesignPattern;

public class StandardShippingCalculator implements ShippingCalculator {
	private double totalCost = 0.0;

	 //Chair: flat rate based on size
	 @Override
	 public void visit(Chair chair) {
	     double cost;
	     switch (chair.getSize().toLowerCase()) {
	         case "small":  cost = 150.00; break;
	         case "medium": cost = 250.00; break;
	         case "large":  cost = 350.00; break;
	         default:       cost = 200.00; break;
	     }
	     totalCost += cost;
	     printReceipt(chair.getName(), "Flat rate (size: " + chair.getSize() + ")", cost);
	 }
	
	 //Sofa: base fee + distance surcharge 
	 @Override
	 public void visit(Sofa sofa) {
	     double baseFee = 500.00;
	     double perKmRate = 3.50;
	     double cost = baseFee + (sofa.getDistanceKm() * perKmRate);
	     totalCost += cost;
	     printReceipt(sofa.getName(),
	             "Base ₱500 + ₱3.50/km × " + sofa.getDistanceKm() + " km", cost);
	 }
	
	 //Table: weight-based, affected by material and size
	 @Override
	 public void visit(Table table) {
	     double baseRate = 300.00;
	
	     double materialMultiplier;
	     switch (table.getMaterial().toLowerCase()) {
	         case "glass":  materialMultiplier = 1.8; break;
	         case "metal":  materialMultiplier = 1.5; break;
	         case "wood":
	         default:       materialMultiplier = 1.0; break;
	     }
	
	     double sizeMultiplier;
	     switch (table.getSize().toLowerCase()) {
	         case "small":  sizeMultiplier = 1.0; break;
	         case "medium": sizeMultiplier = 1.4; break;
	         case "large":  sizeMultiplier = 1.9; break;
	         default:       sizeMultiplier = 1.0; break;
	     }
	
	     double cost = baseRate * materialMultiplier * sizeMultiplier;
	     totalCost += cost;
	     printReceipt(table.getName(),
	             "Base ₱300 × material(" + materialMultiplier + ") × size(" + sizeMultiplier + ")", cost);
	 }
	
	 public double getTotalCost() { 
		 return totalCost;
		 }
	
	 public void resetTotal() { 
		 totalCost = 0.0; 
		 }
	
	 private void printReceipt(String item, String formula, double cost) {
	     System.out.printf("  %-28s | %-40s | ₱%,.2f%n", item, formula, cost);
	 }
}