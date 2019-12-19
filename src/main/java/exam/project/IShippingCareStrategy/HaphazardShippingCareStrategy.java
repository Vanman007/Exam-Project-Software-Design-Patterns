package exam.project.IShippingCareStrategy;

public class HaphazardShippingCareStrategy implements IShippingCareStrategy {

    private double careCostMultiplier = 0.5;

    @Override
    public double calculateShippingCare(double shippingMultiplier, double weight, double size) {
        return shippingMultiplier * (weight + size);
    }

    public void setCareCostMultiplier(double careCostMultiplier) {
        this.careCostMultiplier = careCostMultiplier;
    }

}
