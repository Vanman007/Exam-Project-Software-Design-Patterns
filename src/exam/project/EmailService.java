package exam.project;

public class EmailService implements ISubscriber {
    @Override
    public void update() {
        System.out.println("Update on EmailService");
    }
}
