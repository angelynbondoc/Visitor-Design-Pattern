package visitorDesignPattern;

public class ExpressShippingCalculator implements ShippingCalculator {
	private static final double EXPRESS_MULTIPLIER = 2.0;
	private double totalCost = 0.0;
	
	//Chair: express flat rate
	@Override
	public void visit(Chair chair) {
	     double standardCost;
	     switch (chair.getSize().toLowerCase()) {
	         case "small":  standardCost = 150.00; break;
	         case "medium": standardCost = 250.00; break;
	         case "large":  standardCost = 350.00; break;
	         default:       standardCost = 200.00; break;
	     }
	     double cost = standardCost * EXPRESS_MULTIPLIER;
	     totalCost += cost;
	     printReceipt(chair.getName(), "Express flat rate (×2.0)", cost);
	 }
	
	//Sofa: express distance rate
	@Override
	public void visit(Sofa sofa) {
	     double baseFee = 500.00;
	     double perKmRate = 3.50;
	     double cost = (baseFee + (sofa.getDistanceKm() * perKmRate)) * EXPRESS_MULTIPLIER;
	     totalCost += cost;
	     printReceipt(sofa.getName(), "Express distance rate (×2.0)", cost);
	 }
	
	//Table: express weight-based rate
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
	
	     double cost = baseRate * materialMultiplier * sizeMultiplier * EXPRESS_MULTIPLIER;
	     totalCost += cost;
	     printReceipt(table.getName(), "Express weight-based rate (×2.0)", cost);
	 }
	
	public double getTotalCost() { return totalCost; }
	
	public void resetTotal() { totalCost = 0.0; }
	
	private void printReceipt(String item, String formula, double cost) {
	     System.out.printf("  %-28s | %-40s | ₱%,.2f%n", item, formula, cost);
	 }
	}
