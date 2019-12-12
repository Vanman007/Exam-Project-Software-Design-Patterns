package exam.project.IShippingTypeStrategy;

public class ShipTypeStrategy {

    private double costMultiplier = 1.5;

    public double CalculateShippingMultiplier(int km){
        return costMultiplier;
    }
}
