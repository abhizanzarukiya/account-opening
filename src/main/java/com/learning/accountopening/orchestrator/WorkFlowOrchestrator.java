package com.learning.accountopening.orchestrator;

import com.learning.accountopening.handler.AbstractHandler;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


@Component
public class WorkFlowOrchestrator {

    List<AbstractHandler> handlers;
    List<AbstractHandler> ordered1;

    @Autowired
    public void setHandlers(List<AbstractHandler> handlers) {
        this.handlers = handlers;

        this.ordered1 = List.of(handlers.get(0), handlers.get(1));

        for(int i = 0; i < ordered1.size() - 1; i++) {
            ordered1.get(i).setNextHandler(ordered1.get(i + 1));
        }

    }

    // Orchestractor ordering of handlers
    public void execute(String request, HttpServletResponse response) throws IOException {
        for (AbstractHandler handler : handlers) {
            handler.handleRequest(request, response );
        }
    }

    // lineaar ordering of handlers
    public void executeOrdered1(String request, HttpServletResponse response) throws IOException {
        AbstractHandler handler = ordered1.get(0);
        handler.handleRequest(request, response );

    }

}
