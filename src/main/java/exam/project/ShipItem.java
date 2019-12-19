package exam.project;

import exam.project.IShippingCareStrategy.IShippingCareStrategy;
import exam.project.IShippingTypeStrategy.IShippingTypeStrategy;

public class ShipItem {

    private IShippingTypeStrategy shippingTypeStrategy;
    private IShippingCareStrategy shippingCareStrategy;

    public ShipItem(IShippingCareStrategy shippingCareStrategy, IShippingTypeStrategy shippingTypeStrategy) {
        this.shippingCareStrategy = shippingCareStrategy;
        this.shippingTypeStrategy = shippingTypeStrategy;
    }

    public IShippingTypeStrategy getIShippingTypeStrategy() {
        return shippingTypeStrategy;
    }

    public IShippingCareStrategy getIShippingCareStrategy() {
        return shippingCareStrategy;
    }

    public void setIShippingTypeStrategy(IShippingTypeStrategy shippingTypeStrategy) {
        this.shippingTypeStrategy = shippingTypeStrategy;
    }

    public void setIShippingCareStrategy(IShippingCareStrategy shippingCareStrategy) {
        this.shippingCareStrategy = shippingCareStrategy;
    }

    // Use shippingTypeStrategy and shippingCareStrategy to calculate cost and return it to client
    public double calculateTimeAndCost(double weight, double size, int distance) {
        double shippingMultiplier = this.shippingTypeStrategy.calculateShippingMultiplier(distance);
        return this.shippingCareStrategy.calculateShippingCare(shippingMultiplier, weight, size);
    }
}
