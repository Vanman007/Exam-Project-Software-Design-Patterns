package exam.project.IShippingTypeStrategy;

public class AirStandardTypeStrategy implements IShippingTypeStrategy {

    private double costMultiplier = 2.0;

    public double CalculateShippingMultiplier(int km){
        return costMultiplier;
    }

}
