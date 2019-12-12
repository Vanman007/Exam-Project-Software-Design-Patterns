package exam.project.IShippingTypeStrategy;

public class TruckTypeStrategy {

    private double costMultiplier = 1.0;

    public double CalculateShippingMultiplier(int km){
        return costMultiplier;
    }
}
