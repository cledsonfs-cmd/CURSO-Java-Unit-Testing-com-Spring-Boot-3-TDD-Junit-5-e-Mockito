package br.com.erudio.mockito.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest{
    private final OrderService service = new OrderService();
    private final UUID defaultUuid =  UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private final LocalDateTime defaultDateTime =  LocalDateTime.of(2023,7,4,15,50);

    @DisplayName("Should Include Randon Order Id When NoOrder Id Exists")
    @Test
    void testShouldIncludeRandonOrderId_When_NoOrderIdExists(){

        //Give
        try(MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)){
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            //When
            Order result = service.createOrder("MacBook Pro", 2L, null);
            assertEquals(defaultUuid.toString(),result.getId());
        }
    }

    @DisplayName("Should Include CurrentTime When Create a New Order")
    @Test
    void testShouldIncludeCurrentTime_When_CreateANewOrder(){

        //Give
        try(MockedStatic<LocalDateTime> mockedUuid = mockStatic(LocalDateTime.class)){
            mockedUuid.when(LocalDateTime::now).thenReturn(defaultDateTime);

            //When
            Order result = service.createOrder("MacBook Pro", 2L, null);
            assertEquals(defaultDateTime,result.getCreationDate());
        }
    }
}