//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}
---------------
        import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;





class Order {
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

    public void generateInvoice(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Ice Cream Shop Invoice\n");
            writer.write("==============================\n");

            for (Scoop scoop : scoops) {
                writer.write(String.format("%s - 1 scoop: $%.2f\n", scoop.getFlavor(), scoop.calculatePrice()));
            }

            for (Topping topping : toppings) {
                writer.write(String.format("%s - %d time(s): $%.2f\n", topping.getName(), topping.getQuantity(), topping.calculatePrice()));
            }

            if (serving != null) {
                writer.write(String.format("%s: $%.2f\n", serving.getType(), serving.calculatePrice()));
            }

            writer.write("==============================\n");
            writer.write(String.format("Subtotal: $%.2f\n", calculateSubtotal()));
            writer.write(String.format("Tax: $%.2f\n", calculateTax()));
            writer.write(String.format("Total Amount Due: $%.2f\n", calculateTotal()));

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

// Main class for testing

