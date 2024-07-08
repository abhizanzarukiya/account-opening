package com.learning.accountopening.handler;


import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpResponse;

@Component
@Slf4j
public class ClientOpenHandler extends AbstractHandler {

    @Override
    public void handleRequest(String request, HttpServletResponse response) {
        log.info("ClientOpenHandler: Processing request: {}", request);

        try{
            response.getWriter().println("ClientOpenHandler: Processing request: " + request);
        } catch (Exception e) {
            log.error("Error in ClientOpenHandler: ", e);
        }

        if (nextHandler != null) {
            nextHandler.handleRequest(request, response);
        }
    }

    @Override
    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
