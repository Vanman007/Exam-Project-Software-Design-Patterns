package exam.project;

public class DiscountElectronicsFactory implements IAbstractElectronicsFactory {

    private static volatile DiscountElectronicsFactory instance;

    private DiscountElectronicsFactory() {
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method instead.");
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
        throw new CloneNotSupportedException("Don't clone the singleton.");
    }

    // Serialization-safe
    protected Object readResolve() {
        return getInstance();
    }

}
