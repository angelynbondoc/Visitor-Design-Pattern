package visitorDesignPattern;

public interface ShippingCalculator {
	 void visit(Chair chair);
	 void visit(Sofa sofa);
	 void visit(Table table);
}