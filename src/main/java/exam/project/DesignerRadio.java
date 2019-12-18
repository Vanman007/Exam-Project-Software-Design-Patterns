package exam.project;

public class DesignerRadio extends Radio {

    public DesignerRadio(){
        connectionType = "DAB";
        price = 999.95;
        weight = 10;
        size = 45;
        brand = "B&O";
        name = "Beo DABRA";
    }

    public DesignerRadio(String connectionType, double price, int weight, int size, String brand, String name){
        this.connectionType = connectionType;
        this.price = price;
        this.weight = weight;
        this.size = size;
        this.brand = brand;
        this.name = name;
    }

}
