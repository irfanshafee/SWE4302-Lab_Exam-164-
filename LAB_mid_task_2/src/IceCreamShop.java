import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class IceCreamShop {
    public static void main(String[] args) {
        Order order = new Order();

        // Add scoops
        order.addScoop("Chocolate Fudge", 3.00);
        order.addScoop("Mint Chocolate Chip", 2.80);
        order.addScoop("Strawberry Swirl", 2.75);
        order.addScoop("Pistachio Delight", 3.25);

        // Add toppings
        order.addTopping("Chocolate Chips", 0.50, 1);
        order.addTopping("Fresh Strawberries", 0.50, 2);

  

        // Set serving style
        order.setServing("Waffle Cone", 5.00);



        // Display order summary
        System.out.printf("Subtotal: $%.2f\n", order.calculateSubtotal());
        System.out.printf("Tax: $%.2f\n", order.calculateTax());
        System.out.printf("Total Amount Due: $%.2f\n", order.calculateTotal());

        // Generate invoice
        order.generateInvoice("invoice.txt");
    }


}
