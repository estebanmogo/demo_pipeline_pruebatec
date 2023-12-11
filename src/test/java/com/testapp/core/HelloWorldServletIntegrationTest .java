package com.testapp.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;

public class HelloWorldServletIntegrationTest {

    @Test
    public void testServlet() throws Exception {
        // Crear mocks para HttpServletRequest y HttpServletResponse
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Usar StringWriter para capturar la salida del servlet
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Crear una instancia del servlet y llamar al método doGet
        HelloWorldServlet servlet = new HelloWorldServlet();
        servlet.doGet(request, response);

        // Verificar que la salida es la esperada
        assertEquals("Hello, World.", stringWriter.toString().trim());
    }
}