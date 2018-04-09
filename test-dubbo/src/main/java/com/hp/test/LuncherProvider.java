package com.hp.test;  
  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.context.ApplicationContext;  
  
public class LuncherProvider {  
    public static void main(String[] args) throws Exception {  
        LuncherProvider luncher = new LuncherProvider();  
        luncher.start();  
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟  
    }  
  
    public void start() {  
        String configLocation = "spring/dubbo-provider.xml";  
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);  
        String[] names = context.getBeanDefinitionNames();  
        System.out.print("Beans:");  
        for (String string : names)  
            System.out.print(string + ",");  
        System.out.println();  
    }  
} 