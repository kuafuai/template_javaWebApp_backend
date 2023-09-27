package com.aiassistant;

import com.aiassistant.controller.AdditionController;
import com.aiassistant.controller.AdditionRequest;
import com.aiassistant.controller.AdditionResponse;
import com.aiassistant.exception.AdditionExceptionHandler;
import com.aiassistant.model.AdditionResult;
import com.aiassistant.service.AdditionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class AdditionApplicationTests {

    @Mock
    private AdditionService additionService;

    @InjectMocks
    private AdditionController additionController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddNumbers() {
        AdditionRequest request = new AdditionRequest();
        request.setNumbers(Arrays.asList(1, 2, 3));

        AdditionResult result = new AdditionResult();
        result.setResult(6);

        AdditionResponse expectedResponse = new AdditionResponse();
        expectedResponse.setResult(result);

        when(additionService.addNumbers(request.getNumbers())).thenReturn(result);

        AdditionResponse actualResponse = additionController.addNumbers(request);

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void testHandleInvalidInput() {
        AdditionRequest request = new AdditionRequest();
        request.setNumbers(Arrays.asList(1, -2, 3));

        AdditionResponse expectedResponse = new AdditionResponse();
        expectedResponse.setErrorMessage("Invalid input");

        AdditionResponse actualResponse = additionController.addNumbers(request);

        assertEquals(expectedResponse, actualResponse);
    }
}
