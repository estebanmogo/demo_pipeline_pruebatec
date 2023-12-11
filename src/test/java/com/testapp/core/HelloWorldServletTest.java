package com.testapp.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldServletTest {

    @Test
    public void getMessage_ReturnsHelloWorld() {
        HelloWorldServlet servlet = new HelloWorldServlet();
        assertEquals("Hello, World.", servlet.getMessage());
    }
}
