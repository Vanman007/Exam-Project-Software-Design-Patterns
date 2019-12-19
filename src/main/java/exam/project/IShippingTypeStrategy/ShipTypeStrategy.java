package exam.project.IShippingTypeStrategy;

public class ShipTypeStrategy implements IShippingTypeStrategy {

    private double costMultiplier = 1.5;

    public double calculateShippingMultiplier(int km){
        return costMultiplier;
    }
}
