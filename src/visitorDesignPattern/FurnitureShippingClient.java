package visitorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class FurnitureShippingClient {

    public static void main(String[] args) {

        //Build the furniture catalog
        List<Furniture> order = new ArrayList<>();

        order.add(new Chair("Ergonomic Office Chair", "medium"));
        order.add(new Chair("Wooden Bar Stool",       "small"));
        order.add(new Chair("Executive Gaming Chair", "large"));

        order.add(new Sofa("3-Seater Leather Sofa",  "large",  45.0));
        order.add(new Sofa("Compact Loveseat",        "medium", 12.5));

        order.add(new Table("Oak Dining Table",       "large",  "wood"));
        order.add(new Table("Glass Coffee Table",     "small",  "glass"));
        order.add(new Table("Metal Workshop Table",   "medium", "metal"));

        //Standard Shipping
        StandardShippingCalculator standardCalc = new StandardShippingCalculator();

        printHeader("Standard Shipping Quote");
        printTableHeader();

        for (Furniture item : order) {
            item.accept(standardCalc);//visitor pattern in action
        }

        printFooter(standardCalc.getTotalCost());

        //Express Shipping
        ExpressShippingCalculator expressCalc = new ExpressShippingCalculator();

        printHeader("Express Shipping Quote (2-day delivery)");
        printTableHeader();

        for (Furniture item : order) {
            item.accept(expressCalc);//same elements, different visitor
        }

        printFooter(expressCalc.getTotalCost());

        System.out.println();
        System.out.println("Shipping Comparison");
        System.out.printf( "Standard Total : ₱%,14.2f %n", standardCalc.getTotalCost());
        System.out.printf( "Express Total  : ₱%,14.2f %n", expressCalc.getTotalCost());
        System.out.printf( "Express Premium: ₱%,14.2f %n",
                expressCalc.getTotalCost() - standardCalc.getTotalCost());
        System.out.println();
    }

    //helpers
    private static void printHeader(String title) {
        System.out.println();
        System.out.printf( "%-81s %n", title);
    }

    private static void printTableHeader() {
        System.out.printf("  %-28s   %-40s   %s%n", "Item", "Calculation", "Cost");
        System.out.println("  " + "─".repeat(28) + "───" + "─".repeat(40) + "───" + "─".repeat(12));
    }

    private static void printFooter(double total) {
        System.out.println("  " + "─".repeat(28) + "───" + "─".repeat(40) + "───" + "─".repeat(12));
        System.out.printf("  %-70s  ₱%,.2f%n", "Total Shipping Cost", total);
    }
}