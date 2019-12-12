package exam.project.IShippingCareStrategy;

public class StandardShippingCareStrategy implements IShippingCareStrategy {

    private float careCostMultiplier;

    @Override
    public float CalculateShippingCare(int shippingMultiplier, float weight, float size) {
        return 0;
    }

    public void setCareCostMultiplier(float careCostMultiplier) {
        this.careCostMultiplier = careCostMultiplier;
    }

}
