package exam.project;

public class SMSService implements ISubscriber {

    @Override
    public void update(Order order) {
        System.out.println("Update on SMSService");
    }
}
