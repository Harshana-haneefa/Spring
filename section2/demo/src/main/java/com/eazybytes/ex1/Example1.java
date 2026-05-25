package com.eazybytes.ex1;


import com.eazybytes.ex1.beans.Vehicle;
import com.eazybytes.ex1.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {

    static void main() {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Audi");
        System.out.println("Vehicle name from non-spring context is:" + vehicle.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var veh = context.getBean("vehicle1",Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: "+veh.getName());

        String hello = context.getBean(String.class);
        System.out.println("String value from Spring Context is: "+hello);

        Integer num = context.getBean(Integer.class);
        System.out.println("Integer value from Spring Context is: "+num);

        String hello1 = (String) context.getBean("hello");
        System.out.println("String value from Spring Context is: "+hello1);

        Integer num1 = (Integer) context.getBean("luckyNumber");
        System.out.println("Integer value from Spring Context is: "+num1);

    }
}
