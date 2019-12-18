package exam.project.Unused;

import exam.project.Order;

public class SMSService implements ISubscriber {
    @Override
    public void update(Order order) {
        System.out.println("Update on SMSService");
    }
}
