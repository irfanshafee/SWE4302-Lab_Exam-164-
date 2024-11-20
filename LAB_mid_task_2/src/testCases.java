
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class testCases {

    @Test
    public void testSubtotalCalculation() {
        Order order = new Order();
        order.addScoop("Vanilla", 2.50);
        order.addScoop("Chocolate", 3.00);
        order.addTopping("Crushed Oreo", 0.85, 2); // Two quantities
        order.setServing("Waffle Cone", 5.00);

        double expectedSubtotal = 2.50 + 3.00 + (0.85 * 2) + 5.00;
        assertEquals(expectedSubtotal, order.calculateSubtotal(), 0.01, "Subtotal calculation is incorrect");
    }

    @Test
    public void testTaxCalculation() {
        Order order = new Order();
        order.addScoop("Strawberry", 2.80);
        order.addTopping("Fresh Strawberries", 1.00, 1); // One quantity

        double expectedSubtotal = 2.80 + 1.00;
        double expectedTax = expectedSubtotal * 0.08;
        assertEquals(expectedTax, order.calculateTax(), 0.01, "Tax calculation is incorrect");
    }

    @Test
    public void testTotalCalculation() {
        Order order = new Order();
        order.addScoop("Chocolate Fudge", 3.00);
        order.addTopping("Chocolate Chips", 0.50, 1);
        order.setServing("Paper Cup", 0.00);

        double expectedSubtotal = 3.00 + 0.50;
        double expectedTax = expectedSubtotal * 0.08;
        double expectedTotal = expectedSubtotal + expectedTax;

        assertEquals(expectedTotal, order.calculateTotal(), 0.01, "Total calculation is incorrect");
    }

    @Test
    public void testEmptyOrder() {
        Order order = new Order();
        double expectedSubtotal = 0.00;
        double expectedTax = 0.00;
        double expectedTotal = 0.00;

        assertEquals(expectedSubtotal, order.calculateSubtotal(), 0.01, "Subtotal for empty order should be 0");
        assertEquals(expectedTax, order.calculateTax(), 0.01, "Tax for empty order should be 0");
        assertEquals(expectedTotal, order.calculateTotal(), 0.01, "Total for empty order should be 0");
    }

    @Test
    public void testInvoiceGeneration() {
        Order order = new Order();
        order.addScoop("Mint Chocolate Chip", 2.80);
        order.addTopping("Crushed Oreo", 0.85, 1);
        order.setServing("Paper Cup", 0.00);

        String expectedInvoice = "Ice Cream Shop Invoice\n" +
                "==============================\n" +
                "Mint Chocolate Chip - 1 scoop: $2.80\n" +
                "Crushed Oreo - 1 time(s): $0.85\n" +
                "==============================\n" +
                "Subtotal: $3.65\n" +
                "Tax: $0.29\n" +
                "Total Amount Due: $3.94\n";

        order.generateInvoice("test_invoice.txt");


        try {
            String generatedInvoice = new String(java.nio.file.Files.readAllBytes(java.nio.file.Path.of("test_invoice.txt")));
            assertEquals(expectedInvoice, generatedInvoice, "Invoice content is incorrect");
        } catch (IOException e) {
            fail("Error reading the generated invoice file");
        }
    }
}
