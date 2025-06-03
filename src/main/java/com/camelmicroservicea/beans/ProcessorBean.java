package com.camelmicroservicea.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProcessorBean implements Processor {
    private final Logger logger = LoggerFactory.getLogger(ProcessorBean.class);

    public void process(Exchange exchange) {
        logger.info("Message from processor : {}", exchange.getMessage().getBody());
    }
}
