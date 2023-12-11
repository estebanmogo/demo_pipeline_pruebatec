package com.testapp.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HelloWorldServletTest {

    @Test
    public void doGetWritesHelloWorld() throws Exception {
        // Crear un StringWriter para capturar la salida del servlet
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

        // Crear un HelloWorldServlet y simular la respuesta
        HelloWorldServlet servlet = new HelloWorldServlet();
        HttpServletResponse response = mock(HttpServletResponse.class);
        when(response.getWriter()).thenReturn(writer);

        // Llamar al método doGet y verificar el resultado
        servlet.doGet(null, response);

        writer.flush();
        assertEquals("Hello, World.", stringWriter.toString().trim());
    }
}