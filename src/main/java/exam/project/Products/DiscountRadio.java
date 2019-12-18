package exam.project.Products;

public class DiscountRadio extends Radio {

    public DiscountRadio(){
        connectionType = "AM";
        price = 199.95;
        weight = 20;
        size = 65;
        brand = "Denver";
        name = "DenverOneTwo";
    }

    public DiscountRadio(String connectionType, double price, int weight, int size, String brand, String name){
        this.connectionType = connectionType;
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.brand = brand;
        this.name = name;
    }

}
