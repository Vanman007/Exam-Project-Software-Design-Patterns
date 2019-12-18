package exam.project.Products;

public class MidEndElectronicsFactory implements IAbstractElectronicsFactory {

    private static volatile MidEndElectronicsFactory instance;

    private MidEndElectronicsFactory() {
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method instead.");
        }
    }

    // Singleton proofing
    static MidEndElectronicsFactory getInstance() {
        // Lazy-initialization
        if (instance == null) {
            // Thread-safe
            synchronized (MidEndElectronicsFactory.class) {
                if (instance == null) {
                    instance = new MidEndElectronicsFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public TV createTV() {
        return new MidEndTV();
    }

    @Override
    public Radio createRadio() {
        return new MidEndRadio();
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
