package exam.project.IShippingCareStrategy;

public class SuperFragileShippingCareStrategy implements IShippingCareStrategy {

    private double careCostMultiplier = 2.0;

    @Override
    public double calculateShippingCare(double weight, double size) {
        return careCostMultiplier * (weight + size);
    }

    public void setCareCostMultiplier(double careCostMultiplier) {
        this.careCostMultiplier = careCostMultiplier;
    }

}
