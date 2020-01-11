package exam.project.IShippingCareStrategy;

public class CarefulShippingCareStrategy implements IShippingCareStrategy {

    private double careCostMultiplier = 1.5;

    @Override
    public double calculateShippingCare(double weight, double size) {
        return careCostMultiplier * (weight + size);
    }

    public void setCareCostMultiplier(double careCostMultiplier) {
        this.careCostMultiplier = careCostMultiplier;
    }

}
