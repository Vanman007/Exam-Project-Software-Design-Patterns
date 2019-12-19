package exam.project.Products;

public class DiscountElectronicsFactory implements IAbstractElectronicsFactory {

    private static volatile DiscountElectronicsFactory instance;

    private DiscountElectronicsFactory() {
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("\nUse getInstance() method instead.\n");
        }
    }

    // Singleton proofing
    public static DiscountElectronicsFactory getInstance() {
        // Lazy-initialization
        if (instance == null) {
            // Thread-safe
            synchronized (DiscountElectronicsFactory.class) {
                if (instance == null) {
                    instance = new DiscountElectronicsFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public TV createTV() {
        return new DiscountTV();
    }

    @Override
    public Radio createRadio() {
        return new DiscountRadio();
    }

    // Clone-safe
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("\nDon't clone the singleton.\n");
    }

    // Serialization-safe
    protected Object readResolve() {
        return getInstance();
    }

}
