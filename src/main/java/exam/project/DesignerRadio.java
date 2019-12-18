package exam.project;

public class DesignerRadio extends Radio {

    public DesignerRadio(){
        connectionType = "DAB";
        price = 999.95;
        weight = 10.5;
        size = 45.75;
        brand = "B&O";
        name = "Beo DABRA";
    }

    public DesignerRadio(String connectionType, double price, double weight, double size, String brand, String name){
        this.connectionType = connectionType;
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.brand = brand;
        this.name = name;
    }

}
