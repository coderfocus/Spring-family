import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.UserService;

public class Test {
    public static void main(String[] args) {
        //通过classpath目录下的xml文件创建ApplicationContext
        //ClassPathXmlApplicationContext和FileSystemXmlApplicationContext的区别

//        ClassPathXmlApplicationContext:

//        1.classpath:前缀是不需要的,默认就是指项目的classpath路径下面;
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");

//        2.如果要使用绝对路径,需要加上file:前缀表示这是绝对路径;
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "file:\\E:\\me\\Spring-family\\springioc\\src\\main\\resources\\spring-context.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "file:\\E:\\me\\Spring-family\\springioc\\src\\main\\resources\\context\\spring-context.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "file:\\E:\\me\\Spring-family\\springioc\\src\\main\\context\\spring-context.xml");
//                ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "file:\\E:\\me\\Spring-family\\springioc\\context\\spring-context.xml");
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "file:\\E:\\me\\context\\spring-context.xml");


//        FileSystemXmlApplicationContext:

//        1.没有盘符的是项目工作路径,即项目的根目录Spring-family
//        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("spring-context.xml");

//        2.有盘符表示的是文件绝对路径.
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//                "file:\\E:\\me\\context\\spring-context.xml");


        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHi();
    }
}
