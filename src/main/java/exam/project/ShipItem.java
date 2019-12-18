package exam.project;

import exam.project.IShippingCareStrategy.IShippingCareStrategy;
import exam.project.IShippingTypeStrategy.IShippingTypeStrategy;

public class ShipItem {

    private IShippingTypeStrategy iShippingTypeStrategy;
    private IShippingCareStrategy iShippingCareStrategy;

    public ShipItem(IShippingCareStrategy iShippingCareStrategy, IShippingTypeStrategy iShippingTypeStrategy) {
        this.iShippingCareStrategy = iShippingCareStrategy;
        this.iShippingTypeStrategy = iShippingTypeStrategy;
    }

    public IShippingTypeStrategy getiShippingTypeStrategy() {
        return iShippingTypeStrategy;
    }

    public IShippingCareStrategy getiShippingCareStrategy() {
        return iShippingCareStrategy;
    }

    public void setiShippingTypeStrategy(IShippingTypeStrategy iShippingTypeStrategy) {
        this.iShippingTypeStrategy = iShippingTypeStrategy;
    }

    public void setiShippingCareStrategy(IShippingCareStrategy iShippingCareStrategy) {
        this.iShippingCareStrategy = iShippingCareStrategy;
    }

    // Use shippingTypeStrategy and shippingCareStrategy to calculate cost and return it to client
    public double calculateTimeAndCost(double weight, double size, int distance) {
        double shippingMultiplier = this.iShippingTypeStrategy.CalculateShippingMultiplier(distance);
        return this.iShippingCareStrategy.CalculateShippingCare(shippingMultiplier, weight, size);
    }
}
