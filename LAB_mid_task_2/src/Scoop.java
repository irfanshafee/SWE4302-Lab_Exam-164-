public class Scoop extends Item {
    private String flavor;
    private double price;

    public Scoop(String flavor, double price) {
        this.flavor = flavor;
        this.price = price;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    public String getFlavor() {
        return flavor;
    }

}
