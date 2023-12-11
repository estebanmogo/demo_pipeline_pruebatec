package com.testapp.core;

import com.meterware.httpunit.*;
import org.junit.jupiter.api.*;
import java.net.*;

public class HelloWorldServletIntegrationTest {

    @Test
    public void testServlet() throws Exception {
        WebConversation wc = new WebConversation();
        WebRequest request = new GetMethodWebRequest("http://localhost:8080/hello");
        WebResponse response = wc.getResponse(request);

        Assertions.assertEquals("Hello, World.", response.getText());
    }
}