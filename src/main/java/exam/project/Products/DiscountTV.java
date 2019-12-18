package exam.project.Products;

public class DiscountTV extends TV {

    public DiscountTV(){
        screenType = "CRT";
        resolution = "720p";
        price = 499.95;
        weight = 142.5;
        size = 345.75;
        brand = "Medion";
        name = "Tx67";
    }

    public DiscountTV(String screenType, String resolution, double price, double weight, double size, String brand, String name){
        this.screenType = screenType;
        this.resolution = resolution;
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.brand = brand;
        this.name = name;
    }

}
