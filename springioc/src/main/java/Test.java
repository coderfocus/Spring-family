import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class Test {
    public static void main(String[] args) {
        //通过classpath目录下的xml文件创建ApplicationContext
        //ClassPathXmlApplicationContext[只能读放在web-info/classes目录下的配置文件]和FileSystemXmlApplicationContext的区别

//        ClassPathXmlApplicationContext:

//        1.classpath:前缀是不需要的,默认就是指项目的classpath路径下面;
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");

//        2.只能读放在web-info/classes目录下的配置文件,如果要使用绝对路径,需要加上file:前缀表示这是绝对路径;
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "file:\\E:\\me\\Spring-family\\springioc\\src\\main\\resources\\spring-context.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "file:\\E:\\me\\Spring-family\\springioc\\src\\main\\resources\\context\\spring-context.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "file:\\E:\\me\\Spring-family\\springioc\\src\\main\\context\\spring-context.xml");

//        java.io.FileNotFoundException: E:\me\Spring-family\springioc\context\spring-context.xml (系统找不到指定的路径。)
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "file:\\E:\\me\\Spring-family\\springioc\\context\\spring-context.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHi();
    }
}
