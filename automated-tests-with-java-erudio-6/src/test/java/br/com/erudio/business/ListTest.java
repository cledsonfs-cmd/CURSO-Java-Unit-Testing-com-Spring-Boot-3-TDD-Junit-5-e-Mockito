package br.com.erudio.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

public class ListTest {

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturn10(){
        //Give
        List<?> list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(10);

        //When
        //Then
        Assertions.assertEquals(10, list.size());

    }

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturnMultipleValues(){
        //Give
        List<?> list = Mockito.mock(List.class);
        Mockito.when(list.size()).thenReturn(10).thenReturn(20);

        //When
        //Then
        Assertions.assertEquals(10, list.size());
        Assertions.assertEquals(20, list.size());
        Assertions.assertEquals(20, list.size());

    }

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturnErudio(){
        //Give
        var list = Mockito.mock(List.class);
        Mockito.when(list.get(0)).thenReturn("Erudio");

        //When
        //Then
        Assertions.assertEquals("Erudio", list.get(0));
        Assertions.assertNull(list.get(1));
    }

    @Test
    void testMocckingList_When_GetIsCalledWithArgumentMathcer_ShouldReturnErudio(){
        //Give
        var list = Mockito.mock(List.class);
        Mockito.when(list.get(anyInt())).thenReturn("Erudio");

        //When
        //Then
        Assertions.assertEquals("Erudio", list.get(anyInt()));
    }

    @Test
    void testMocckingList_When_ThrowsAnException(){
        //Give
        var list = Mockito.mock(List.class);
        Mockito.when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar"));

        //When
        //Then
        Assertions.assertThrows(RuntimeException.class, () ->list.get(anyInt()), ()-> "Should throw RuntimeException");
    }
}
