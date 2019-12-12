package exam.project.IShippingCareStrategy;

public class HaphazardShippingCareStrategy implements IShippingCareStrategy {

    private double careCostMultiplier = 0.5;

    @Override
    public double CalculateShippingCare(double shippingMultiplier, double weight, double size) {
        return 0;
    }

    public void setCareCostMultiplier(double careCostMultiplier) {
        this.careCostMultiplier = careCostMultiplier;
    }

}
