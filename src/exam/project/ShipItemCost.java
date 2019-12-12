package exam.project;

import exam.project.IShippingCareStrategy.IShippingCareStrategy;
import exam.project.IShippingTypeStrategy.IShippingTypeStrategy;

public class ShipItemCost {

    private IShippingTypeStrategy iShippingTypeStrategy;
    private IShippingCareStrategy iShippingCareStrategy;

    public ShipItemCost(IShippingCareStrategy iShippingCareStrategy, IsShippingTypeStrategy isShippingTypeStrategy) {
        this.iShippingCareStrategy = iShippingCareStrategy;
        this.iShippingTypeStrategy = isShippingTypeStrategy;
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

    public double calculateTimeAndCost(double weight, double size, int distance) {
        return 0;
    }
}
