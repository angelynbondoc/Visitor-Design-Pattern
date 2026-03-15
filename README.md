# Visitor Design Pattern — Furniture Shipping Cost

### Background
E-commerce platforms that sell physical goods such as furniture face the challenge of calculating accurate shipping costs. Different furniture types vary significantly in size, weight, and handling requirements, making a one-size-fits-all approach ineffective. A scalable solution is needed that separates shipping logic from the furniture classes themselves.

### Objective
Implement a furniture shipping cost calculator using the Visitor Design Pattern. The system allows different shipping strategies to be applied across various furniture types without modifying the furniture classes, promoting flexibility and separation of concerns.

### Requirements
- **Furniture Item** — An interface representing furniture products such as chairs, tables, and sofas, each with its own physical attributes (e.g., size, weight, delivery distance).
- **Shipping Visitor** — A visitor interface that defines a visit operation for each type of furniture item, allowing shipping cost logic to be implemented externally from the furniture classes.
- **Shipping Cost Process:**
  - The system initializes one or more concrete visitors, each representing a shipping strategy (e.g., standard, express).
  - When a shipping cost is needed, the furniture item accepts a visitor via the `accept()` method.
  - The visitor then calls the appropriate `visit()` method based on the furniture type, applying the correct cost calculation logic.
- **Validation** — Ensures that each furniture type is handled by the correct visit method, and that shipping costs are computed accurately based on the item's attributes and the chosen shipping strategy.
