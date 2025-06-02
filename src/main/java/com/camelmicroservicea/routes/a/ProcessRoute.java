package com.camelmicroservicea.routes.a;

import com.camelmicroservicea.beans.GetCurrentTimeBean;
import com.camelmicroservicea.beans.LogComponent;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ProcessRoute extends RouteBuilder {

    private final GetCurrentTimeBean getCurrentTimeBean;
    private final LogComponent logComponent;

    public ProcessRoute(GetCurrentTimeBean getCurrentTimeBean, LogComponent logComponent) {
        this.getCurrentTimeBean = getCurrentTimeBean;
        this.logComponent = logComponent;
    }

    @Override
    public void configure() {
        from("timer:third_route")
                .log("${body}")
                .transform().constant("My constant message")
                .log("${body}")
                .bean(getCurrentTimeBean)
                .log("${body}")
                .bean(logComponent)
                .log("${body}");
    }
}
