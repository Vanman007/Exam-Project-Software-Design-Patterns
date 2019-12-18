package exam.project;

public class SMSService implements ISubscriber {
    @Override
    public void update() {
        System.out.println("Update on SMSService");
    }
}
