package exam.project.Unused;

import exam.project.Order;

public class EmailService implements ISubscriber {
    @Override
    public void update(Order order)  {
        System.out.println("Update on EmailService");
        //JavaMailUtil.sendMail("tp.vanman@gmail.com");
    }
}
