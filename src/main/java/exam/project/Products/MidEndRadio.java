package exam.project.Products;

public class MidEndRadio extends Radio {

    public MidEndRadio(){
        connectionType = "FM/AM";
        price = 499.95;
        weight = 17;
        size = 55;
        brand = "Pure";
        name = "Pop maxi";
    }

    public MidEndRadio(String connectionType, double price, int weight, int size, String brand, String name){
        this.connectionType = connectionType;
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.brand = brand;
        this.name = name;
    }

}
