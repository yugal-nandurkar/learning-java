package microteam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationOne {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-configuration.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        String userName = userDao.getUserNameById(1);
        System.out.println("User Name: " + userName);
    }
}
