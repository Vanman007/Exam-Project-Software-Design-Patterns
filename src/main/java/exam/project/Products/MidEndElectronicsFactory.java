package exam.project.Products;

public class MidEndElectronicsFactory implements IAbstractElectronicsFactory {

    private static volatile MidEndElectronicsFactory instance;

    private MidEndElectronicsFactory() {
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("\nUse getInstance() method instead.\n");
        }
    }

    // Singleton proofing
    public static MidEndElectronicsFactory getInstance() {
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
        throw new CloneNotSupportedException("\nDon't clone the singleton.\n");
    }

    // Serialization-safe
    protected Object readResolve() {
        return getInstance();
    }

}
