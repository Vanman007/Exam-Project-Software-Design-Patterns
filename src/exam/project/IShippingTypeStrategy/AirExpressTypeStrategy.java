package exam.project.IShippingTypeStrategy;

public class AirExpressTypeStrategy {

    private double costMultiplier = 4.0;

    public double CalculateShippingMultiplier(int km){
        return costMultiplier;
    }

}
