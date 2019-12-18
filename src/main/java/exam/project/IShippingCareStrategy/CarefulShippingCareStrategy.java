package exam.project.IShippingCareStrategy;

public class CarefulShippingCareStrategy implements IShippingCareStrategy {

    private double careCostMultiplier = 1.5;

    @Override
    public double CalculateShippingCare(double shippingMultiplier, double weight, double size) {
        return 0;
    }

    public void setCareCostMultiplier(double careCostMultiplier) {
        this.careCostMultiplier = careCostMultiplier;
    }

}
