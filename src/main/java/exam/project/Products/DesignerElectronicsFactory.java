package exam.project.Products;

public class DesignerElectronicsFactory implements IAbstractElectronicsFactory {

    private static volatile DesignerElectronicsFactory instance;

    private DesignerElectronicsFactory() {
        // Reflection-safe
        if (instance != null) {
            throw new RuntimeException("\nUse getInstance() method instead.\n");
        }
    }

    // Singleton proofing
    public static DesignerElectronicsFactory getInstance() {
        // Lazy-initialization
        if (instance == null) {
            // Thread-safe
            synchronized (DesignerElectronicsFactory.class) {
                if (instance == null) {
                    instance = new DesignerElectronicsFactory();
                }
            }
        }
        return instance;
    }


    @Override
    public TV createTV() {
        return new DesignerTV();
    }

    @Override
    public Radio createRadio() {
        return new DesignerRadio();
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
