package exam.project;

import exam.project.Products.*;

import java.util.ArrayList;

public class Menu {
    private static void printProductList() {
        System.out.println("1: Discount TV");
        System.out.println("2: Mid-tier TV");
        System.out.println("3: Designer TV");
        System.out.println("4: Discount Radio");
        System.out.println("5: Mid-tier Radio");
        System.out.println("6: Designer Radio");
    }

    public static void printMenu(MenuState menuState) {
        switch (menuState) {
            case OPTION_SELECTION:
                System.out.println("Select an option:");
                System.out.println("1: Add stock");
                System.out.println("2: Ship order");
                break;
            case ADD_PRODUCT:
                System.out.println("Which product do you wish to increase?");
                printProductList();
                break;
            case ADD_ORDER:
                System.out.println("Which products do you wish to ship?");
                printProductList();
                System.out.println("7: All done - ship it!");
                break;
            default:
                System.out.println("Unknown state.");
                break;
        }
    }

    public static MenuState getOptionState(MenuState menuState, String option) {
        if (option.toLowerCase().equals("exit")) {
            return MenuState.EXITING;
        }
        if (menuState == MenuState.OPTION_SELECTION) {
            switch (option) {
                case "1":
                    return MenuState.ADD_PRODUCT;
                case "2":
                    return MenuState.ADD_ORDER;
                default:
                    return MenuState.OPTION_SELECTION;
            }
        }
        return MenuState.EXITING;
    }

    public static ArrayList<ElectronicsProduct> getProductsForOrder(ElectronicsProduct product, IAbstractElectronicsFactory factory,
                                                                    int quantity, String command) {
        ArrayList<ElectronicsProduct> products = new ArrayList<>();
        switch (command) {
            case "1":
            case "2":
            case "3":
                for (int i = 0; i < quantity; i++) {
                    products.add(factory.createTV());
                }
                break;
            case "4":
            case "5":
            case "6":
                for (int i = 0; i < quantity; i++) {
                    products.add(factory.createRadio());
                }
                break;
            default:
                return null;
        }
        return products;
    }

    public static ArrayList<ElectronicsProduct> getProductForOrder(ElectronicsProduct product, IAbstractElectronicsFactory factory,
                                                                    int quantity, String command) {
        ArrayList<ElectronicsProduct> products = new ArrayList<>();
        switch (command) {
            case "1":
            case "2":
            case "3":
                for (int i = 0; i < quantity; i++) {
                    products.add(factory.createTV());
                }
                break;
            case "4":
            case "5":
            case "6":
                for (int i = 0; i < quantity; i++) {
                    products.add(factory.createRadio());
                }
                break;
            default:
                return null;
        }
        return products;
    }

    public static ElectronicsProduct getProductObjectFromSelection(String stockToIncrease) {
        IAbstractElectronicsFactory factory;
        switch (stockToIncrease) {
            case "1":
                factory = DiscountElectronicsFactory.getInstance();
                return factory.createTV();
            case "2":
                factory = MidEndElectronicsFactory.getInstance();
                return factory.createTV();
            case "3":
                factory = DesignerElectronicsFactory.getInstance();
                return factory.createTV();
            case "4":
                factory = DiscountElectronicsFactory.getInstance();
                return factory.createRadio();
            case "5":
                factory = MidEndElectronicsFactory.getInstance();
                return factory.createRadio();
            case "6":
                factory = DesignerElectronicsFactory.getInstance();
                return factory.createRadio();
            default:
                return null;
        }
    }

    public static boolean isValidInput(String command) {
        switch (command) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
                return true;
            default:
                return false;
        }
    }

    public static IAbstractElectronicsFactory getAppropriateFactory(String command) {
        switch (command) {
            case "1":
            case "4":
                return DiscountElectronicsFactory.getInstance();
            case "2":
            case "5":
                return MidEndElectronicsFactory.getInstance();
            case "3":
            case "6":
                return DesignerElectronicsFactory.getInstance();
            default:
                return null;
        }
    }

    public static String getProductFromSelection(String stockToIncrease) {
        switch (stockToIncrease) {
            case "1":
                return "Discount TV";
            case "2":
                return "Mid-tier TV";
            case "3":
                return "Designer TV";
            case "4":
                return "Discount Radio";
            case "5":
                return "Mid-tier Radio";
            case "6":
                return "Designer Radio";
            default:
                return null;
        }
    }

    public static int getNumberFromInput(String increase) {
        int increaseInt = 0;
        if (increase == null) {
            return increaseInt;
        }
        try {
            increaseInt = Integer.parseInt(increase);
        } catch (NumberFormatException nfe) {
            return increaseInt;
        }
        return increaseInt;
    }

    public static void addStock(int increase, ElectronicsProduct product, Inventory inventory) {
        // TODO
        for (int i = 0; i < increase; i++) {
            inventory.addProduct(product);
        }
        System.out.println("Add " + product.getClass().getSimpleName() + " to " + " stock.");
    }

    public static void addToOrder(int increase, String product, ArrayList<ElectronicsProduct> products) {
        // TODO - should return array of electronic products
        System.out.println("Add " + increase + " " + product + "s to from stock to order.");
    }

    // TODO
    public static void shipIt(TEMP_Order order) {
        System.out.println(order);
        System.out.println("Shipping it!");
    }
}
