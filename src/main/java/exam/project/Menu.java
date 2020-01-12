package exam.project;

import exam.project.IShippingCareStrategy.*;
import exam.project.IShippingTypeStrategy.*;
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
                System.out.println("2: Create order");
                break;
            case ADD_PRODUCT:
                System.out.println("Which product do you wish to increase?");
                printProductList();
                break;
            case ADD_ORDER:
                System.out.println("Which products do you wish add to the order?");
                printProductList();
                System.out.println("7: All done - add order!");
                break;
            case ADD_TYPE_STRATEGY:
                System.out.println("Choose shipping type:");
                System.out.println("1: Air Standard");
                System.out.println("2: Air Express");
                System.out.println("3: Ship");
                System.out.println("4: Truck");
                break;
            case ADD_CARE_STRATEGY:
                System.out.println("Choose care type:");
                System.out.println("1: Haphazard");
                System.out.println("2: Standard");
                System.out.println("3: Careful");
                System.out.println("4: Super Fragile");
                break;
            case ADD_DISTANCE:
                System.out.println("Choose distance:");
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

    public static IShippingTypeStrategy getAppropriateShippingTypeStrategy(String command) {
        switch (command) {
            case "1":
                return new AirStandardTypeStrategy();
            case "2":
                return new AirExpressTypeStrategy();
            case "3":
                return new ShipTypeStrategy();
            case "4":
                return new TruckTypeStrategy();
            default:
                return null;
        }
    }

    public static IShippingCareStrategy getAppropriateShippingCareStrategy(String command) {
        switch (command) {
            case "1":
                return new HaphazardShippingCareStrategy();
            case "2":
                return new StandardShippingCareStrategy();
            case "3":
                return new CarefulShippingCareStrategy();
            case "4":
                return new SuperFragileShippingCareStrategy();
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
            if (increaseInt < 0) {
                return 0;
            }
        } catch (NumberFormatException nfe) {
            return increaseInt;
        }
        return increaseInt;
    }

    public static void addStock(int increase, String productToAdd) {
        System.out.println("Add " + increase + " of " + getProductName(productToAdd) + "s to " + "stock.");
        ArrayList<ElectronicsProduct> productsToAdd = new ArrayList<>();
        for (int i = 0; i < increase; i++) {
            productsToAdd.add(getProductObjectFromSelection(productToAdd));
        }
        Inventory.getInstance().addProducts(productsToAdd);
    }

    public static void addOrder(Order order) {
        System.out.println("\nAdding order:");
        System.out.println("Size: " + order.getItems().size());
        System.out.println("Type: " + order.getShippingTypeStrategy().getClass().getSimpleName());
        System.out.println("Care: " + order.getShippingCareStrategy().getClass().getSimpleName());
        System.out.println("Distance: " + order.getDistance() + "\n");
        OrderBook.getInstance().addOrder(order);
    }

    private static String getProductName(String number) {
        switch (number) {
            case "1":
                return DiscountTV.class.getSimpleName();
            case "2":
                return MidEndTV.class.getSimpleName();
            case "3":
                return DesignerTV.class.getSimpleName();
            case "4":
                return DiscountRadio.class.getSimpleName();
            case "5":
                return MidEndRadio.class.getSimpleName();
            case "6":
                return DesignerRadio.class.getSimpleName();
            default:
                return "Unknown product.";
        }
    }
}
