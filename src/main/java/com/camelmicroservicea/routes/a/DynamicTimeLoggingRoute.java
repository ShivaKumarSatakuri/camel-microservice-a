package com.camelmicroservicea.routes.a;

import com.camelmicroservicea.beans.GetCurrentTimeBean;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Demonstration of live time capture using spring boot bean
 */
@Component
public class DynamicTimeLoggingRoute extends RouteBuilder {

    private final GetCurrentTimeBean getCurrentTimeBean;

    public DynamicTimeLoggingRoute(GetCurrentTimeBean getCurrentTimeBean) {
        this.getCurrentTimeBean = getCurrentTimeBean;
    }

    @Override
    public void configure() {
        from("timer:second_route")
                .bean(getCurrentTimeBean)
                .to("log:second_route");
    }
}
