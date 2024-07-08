package com.learning.accountopening.controller;


import com.learning.accountopening.orchestrator.WorkFlowOrchestrator;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.http.HttpResponse;

@RestController
@Slf4j
public class OpenController {

      @Autowired
      WorkFlowOrchestrator workFlowOrchestrator;

      @GetMapping("/open")
      public void openAccount(HttpServletResponse response) throws IOException {
            String request = "Open Account";
            log.info("OpenController: Processing request: {}", request);
            workFlowOrchestrator.execute(request, response);
      }

      @GetMapping("/openOrdered1")
      public void openAccountOrdered1(HttpServletResponse response) throws IOException {
          String request = "Open Account";
          log.info("OpenController: Processing request: {}", request);
          workFlowOrchestrator.executeOrdered1(request, response);
      }

      @GetMapping("/")
      public void home() {
            log.info("OpenController: Home");
            System.out.println("Hello");
      }

}
