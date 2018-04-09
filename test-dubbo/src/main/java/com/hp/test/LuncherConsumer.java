package com.hp.test;  
  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
  
public class LuncherConsumer {  
    public static void main(String[] args) throws Exception {  
        LuncherConsumer luncher = new LuncherConsumer();  
        luncher.start();  
    }  
  
  
    void start() {  
        String configLocation = "spring/dubbo-consumer.xml";  
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);  
        String[] names = context.getBeanDefinitionNames();  
        System.out.print("Beans:");  
        for (String string : names) {  
            System.out.print(string);  
            System.out.print(",");  
        }  
        System.out.println();  
  
  
        DemoService ds = (DemoService) context.getBean("demoConsumeService");  
        System.out.println(ds.sayHello("hehe"));  
        System.out.println(ds.getUsers());  
    }  
}  