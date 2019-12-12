package exam.project;

public class Inventory implements ISubscriber {
    @Override
    public void update() {
        System.out.println("Update on Inventory");
    }
}
