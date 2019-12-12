package exam.project.IShippingTypeStrategy;

public class AirStandardTypeStrategy {

    private double costMultiplier = 2.0;

    public double CalculateShippingMultiplier(int km){
        return costMultiplier;
    }

}
