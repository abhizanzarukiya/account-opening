package com.learning.accountopening.handler;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.http.HttpResponse;

abstract public class AbstractHandler {

    protected AbstractHandler nextHandler;
    abstract public void handleRequest(String request, HttpServletResponse response);

    abstract public void setNextHandler(AbstractHandler nextHandler);

}
