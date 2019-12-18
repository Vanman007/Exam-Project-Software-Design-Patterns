package exam.project;

public class MidEndTV extends TV {

    public MidEndTV(){
        screenType = "Flatscreen";
        resolution = "Full HD";
        price = 2499.95;
        weight = 52;
        size = 175;
        brand = "Samsung";
        name = "SamsungTV2019xt";
    }

    public MidEndTV(String screenType, String resolution, double price, int weight, int size, String brand, String name){
        this.screenType = screenType;
        this.resolution = resolution;
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.brand = brand;
        this.name = name;
    }

}
