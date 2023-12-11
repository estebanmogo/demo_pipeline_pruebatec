package com.testapp.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class HelloWorldServletIntegrationTest {

    @Test
    public void testServlet() throws Exception {
        // Crear mocks para HttpServletRequest y HttpServletResponse
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Usar ByteArrayOutputStream para capturar la salida del servlet
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        when(response.getOutputStream()).thenReturn(new DelegatingServletOutputStream(outputStream));

        // Crear una instancia del servlet y llamar al método doGet
        HelloWorldServlet servlet = new HelloWorldServlet();
        servlet.doGet(request, response);

        // Verificar que la salida es la esperada
        assertEquals("Hello, World.", outputStream.toString().trim());
    }

    // Clase auxiliar para simular ServletOutputStream
    private static class DelegatingServletOutputStream extends javax.servlet.ServletOutputStream {
        private final ByteArrayOutputStream outputStream;

        public DelegatingServletOutputStream(ByteArrayOutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override
        public void write(int b) throws IOException {
            outputStream.write(b);
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setWriteListener(javax.servlet.WriteListener writeListener) {
            // No es necesario implementar para esta prueba
        }
    }
}