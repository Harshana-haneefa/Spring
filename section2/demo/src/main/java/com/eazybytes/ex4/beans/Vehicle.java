package com.eazybytes.ex4.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

public class Vehicle{
    public Vehicle(){
        System.out.println("Vehicle bean created");
    }
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "name='" + name + '\'' + '}';
    }

    //    @Override
//    public void afterPropertiesSet() throws Exception {
//        this.name="Tesla";
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("Destroying Vehicle Bean");
//    }

//    @PostConstruct
//    public void initialize(){
//        this.name="Honda";
//    }

//    @PreDestroy
//    public void destroy(){
//        System.out.println("Destroying Vehicle Bean");
//    }
}
