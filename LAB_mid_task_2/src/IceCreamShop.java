
public class IceCreamShop {
    public static void main(String[] args) {
        Order order = new Order();

       
        order.addScoop("Chocolate Fudge", 3.00);
        order.addScoop("Mint Chocolate Chip", 2.80);
        order.addScoop("Strawberry Swirl", 2.75);
        order.addScoop("Pistachio Delight", 3.25);


        order.addTopping("Chocolate Chips", 0.50, 1);
        order.addTopping("Fresh Strawberries", 0.50, 2);




        order.setServing("Waffle Cone", 5.00);




        System.out.printf("Subtotal: $%.2f\n", order.calculateSubtotal());
        System.out.printf("Tax: $%.2f\n", order.calculateTax());
        System.out.printf("Total Amount Due: $%.2f\n", order.calculateTotal());


        order.generateInvoice("invoice.txt");
    }


}
