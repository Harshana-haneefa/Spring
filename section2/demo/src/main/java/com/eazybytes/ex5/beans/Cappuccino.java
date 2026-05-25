package com.eazybytes.ex5.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component ("cappuccino")
//@Primary
public class Cappuccino implements Coffee{

    @Override
    public String MakeCoffee() {
        return "Cappuccino Coffee";
    }
}
