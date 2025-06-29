package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVoidMethodLogging() {
        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.logMessage("Mockito is awesome!");

        verify(mockApi).log("Mockito is awesome!");
    }
    public void testMultipleReturnValues() {
        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData())
            .thenReturn("First")
            .thenReturn("Second")
            .thenReturn("Third");

        MyService service = new MyService(mockApi);

        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
        assertEquals("Third", service.fetchData());
    }
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.process();

        InOrder inOrder = inOrder(mockApi);

        inOrder.verify(mockApi).log("Start");
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).log("End");
    }

    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        doThrow(new RuntimeException("Log failed")).when(mockApi).log("fail");

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.safeLog("fail");
        });

        assertEquals("Log failed", exception.getMessage());
    }
}
