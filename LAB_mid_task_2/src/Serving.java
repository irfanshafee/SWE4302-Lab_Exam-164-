import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
