package com.zsk.demo;

import com.zsk.demo.listener.ApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;

import java.util.Set;

@SpringBootApplication
public class SpringbootLog4j2DemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringbootLog4j2DemoApplication.class);
        Set<ApplicationListener<?>> is = app.getListeners();
        ApplicationStartedEventListener asel = new ApplicationStartedEventListener();
        app.addListeners(asel);
        app.run(args);
//                SpringApplication.run(SpringbootLog4j2DemoApplication.class, args);
    }

}
