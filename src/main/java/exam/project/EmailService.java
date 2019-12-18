package exam.project;

public class EmailService implements ISubscriber {

    @Override
    public void update(Order order) {

        System.out.println("Update on EmailService");
        //JavaMailUtil.sendMail("tp.vanman@gmail.com");

    }
}
