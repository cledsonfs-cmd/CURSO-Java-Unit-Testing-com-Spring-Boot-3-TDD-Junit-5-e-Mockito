package br.com.erudio.mockito.constructor;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

class CheckoutServiceTest {

    @Test
    void testMockObjectContruction(){
        try(MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class,(mock, context) -> {
            when(mock.chargeCustomer(anyString(), any(BigDecimal.class))).thenReturn(BigDecimal.TEN);
        })){
            CheckoutService service = new CheckoutService();

            //When
            BigDecimal result = service.purchaseProduct("MacBook Pro","42");

            //Then
            assertEquals(BigDecimal.TEN, result);
            assertEquals(1, mocked.constructed().size());
        }
    }
}