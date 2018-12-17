package com.ifi.tp;


import org.apache.activemq.broker.BrokerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class GuiApp {

    public static void main(String... args) throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:61617");
        broker.setPersistent(false);
        broker.start();

        SpringApplication.run(GuiApp.class, args);
    }

}


