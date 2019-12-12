package exam.project.IShippingCareStrategy;

public class CarefulShippingCareStrategy implements IShippingCareStrategy {

    private double careCostMultiplier;

    @Override
    public double CalculateShippingCare(int shippingMultiplier, double weight, double size) {
        return 0;
    }

    public void setCareCostMultiplier(double careCostMultiplier) {
        this.careCostMultiplier = careCostMultiplier;
    }

}
