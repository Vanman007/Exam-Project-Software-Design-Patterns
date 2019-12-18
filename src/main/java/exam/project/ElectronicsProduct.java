package exam.project;

public abstract class ElectronicsProduct {

    protected double price;
    protected String name;
    protected int weight;
    protected int size;
    protected String brand;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }
}
