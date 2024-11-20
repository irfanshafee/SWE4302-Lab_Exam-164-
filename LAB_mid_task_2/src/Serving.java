;

public class Serving extends Item{

    private String type;
    private double price;

    public Serving(String type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
