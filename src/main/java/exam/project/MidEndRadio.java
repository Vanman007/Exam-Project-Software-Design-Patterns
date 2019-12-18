package exam.project;

public class MidEndRadio extends Radio {

    public MidEndRadio(){
        connectionType = "FM/AM";
        price = 499.95;
        weight = 17.5;
        size = 55.75;
        brand = "Pure";
        name = "Pop maxi";
    }

    public MidEndRadio(String connectionType, double price, double weight, double size, String brand, String name){
        this.connectionType = connectionType;
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.brand = brand;
        this.name = name;
    }

}
