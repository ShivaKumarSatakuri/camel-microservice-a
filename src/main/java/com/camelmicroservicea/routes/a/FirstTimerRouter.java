package com.camelmicroservicea.routes.a;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Implementing a basic camel route. We must inherit RouteBuilder and override configure method to implement a route.
 * Here, we are using two keywords : timer & log.
 * 'timer' : will let the route know that we are going to track time
 * 'log' : will log the data to console.
 * Note that we have used from, transform and to methods in configure method.
 * <p>
 * from() : used to read a route
 * transform() : used to transform or construct our own data object
 * to() : used to direct the data object to another route
 */
//@Component
public class FirstTimerRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:first_timer")
                // This will print constant time as shown below
                // Exchange[ExchangePattern: InOnly, BodyType: String, Body: Time now is : 2025-06-02T18:12:29.517023600]
                .transform().constant("Time now is : " + LocalDateTime.now())
                .to("log:first_timer");
    }
}