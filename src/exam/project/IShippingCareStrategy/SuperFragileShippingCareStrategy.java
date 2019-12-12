package exam.project.IShippingCareStrategy;

public class SuperFragileShippingCareStrategy implements IShippingCareStrategy {

    private double careCostMultiplier = 2.0;

    @Override
    public double CalculateShippingCare(double shippingMultiplier, double weight, double size) {
        return 0;
    }

    public void setCareCostMultiplier(double careCostMultiplier) {
        this.careCostMultiplier = careCostMultiplier;
    }

}
