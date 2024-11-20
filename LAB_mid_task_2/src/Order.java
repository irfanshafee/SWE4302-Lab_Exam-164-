import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static final double TAX_RATE = 0.08;

    private List<Scoop> scoops;
    private List<Topping> toppings;
    private Serving serving;

    public Order() {
        scoops = new ArrayList<>();
        toppings = new ArrayList<>();
    }
    public void addScoop(String flavor, double price) {
        scoops.add(new Scoop(flavor, price));
    }

    public void addTopping(String name, double price, int quantity) {
        toppings.add(new Topping(name, price, quantity));
    }

    public void setServing(String type, double price) {
        serving = new Serving(type, price);
    }
    public double calculateSubtotal() {
        double total = 0.0;
        for (Scoop scoop : scoops) {
            total += scoop.calculatePrice();
        }
        for (Topping topping : toppings) {
            total += topping.calculatePrice();
        }
        if (serving != null) {
            total += serving.calculatePrice();
        }
        return total;
    }

    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

}
