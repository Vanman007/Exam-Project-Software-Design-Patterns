package exam.project.IShippingTypeStrategy;

public class TruckTypeStrategy {
    private float costMultiplier=0;

    public float CalculateShippingMultiplier(int km){
        return costMultiplier;
    }
}
