package com.testapp.core;

import static org.mockito.Mockito.*;
import javax.servlet.http.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class HelloWorldServletTest {

    private final HttpServletRequest request = mock(HttpServletRequest.class);
    private final HttpServletResponse response = mock(HttpServletResponse.class);
    private final HelloWorldServlet servlet = new HelloWorldServlet();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() throws IOException {
        PrintWriter writer = new PrintWriter(outputStream);
        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void doGetWritesHelloWorld() throws ServletException, IOException {
        servlet.doGet(request, response);
        outputStream.flush(); // Asegúrate de que se escriba todo en el stream
        String result = outputStream.toString();
        Assertions.assertEquals("Hello, World.", result.trim());
    }
}
