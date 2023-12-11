package com.testapp.core;

import static org.mockito.Mockito.*;
import javax.servlet.http.*;
import org.junit.jupiter.api.*;
import java.io.*;

public class HelloWorldServletTest {

    private final HttpServletRequest request = mock(HttpServletRequest.class);
    private final HttpServletResponse response = mock(HttpServletResponse.class);
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final HelloWorldServlet servlet = new HelloWorldServlet();

    @BeforeEach
    public void setUp() throws IOException {
        ServletOutputStream servletOutputStream = new ServletOutputStream() {
            @Override
            public void write(int b) {
                outputStream.write(b);
            }

            @Override
            public boolean isReady() {
            }

            @Override
            public void setWriteListener(WriteListener writeListener) {

            }
        };

        when(response.getOutputStream()).thenReturn(servletOutputStream);
    }

    @Test
    public void doGetWritesHelloWorld() throws ServletException, IOException {
        servlet.doGet(request, response);
        String result = outputStream.toString();
        Assertions.assertEquals("Hello, World.", result);
    }
}