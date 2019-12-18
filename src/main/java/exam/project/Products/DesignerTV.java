package exam.project.Products;

public class DesignerTV extends TV {

    public DesignerTV(){
        screenType = "Curve screen";
        resolution = "4k Ultra HD";
        price = 4999.95;
        weight = 42.5;
        size = 145.75;
        brand = "B&O";
        name = "Beo curve";
    }

    public DesignerTV(String screenType, String resolution, double price, double weight, double size, String brand, String name){
        this.screenType = screenType;
        this.resolution = resolution;
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.brand = brand;
        this.name = name;
    }

}
