package com.bortnichuk;

import com.bortnichuk.view.WindowView;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        WindowView windowView = context.getBean("windowView", WindowView.class);
        windowView.input();
    }
}
