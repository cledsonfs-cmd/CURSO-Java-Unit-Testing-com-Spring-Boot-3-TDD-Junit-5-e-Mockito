package br.com.erudio.business;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

public class ListBDDTest {

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturn10(){
        //Give
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10);

        //When
        //Then
        assertThat(list.size(), is(10));

    }

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturnMultipleValues(){
        //Give
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20);

        //When
        //Then
        assertThat(list.size(),is(10));
        assertThat(list.size(),is(20));
        assertThat(list.size(),is(20));

    }

    @Test
    void testMocckingList_When_SizeIsCalled_ShouldReturnErudio(){
        //Give
        var list = mock(List.class);
        given(list.get(0)).willReturn("Erudio");

        //When
        //Then
        assertThat(list.get(0),is("Erudio"));
        assertNull(list.get(1));
    }

    @Test
    void testMocckingList_When_GetIsCalledWithArgumentMathcer_ShouldReturnErudio(){
        //Give
        var list = mock(List.class);
        given(list.get(anyInt())).willReturn("Erudio");

        //When
        //Then
        assertThat(list.get(anyInt()),is("Erudio"));
    }

    @Test
    void testMocckingList_When_ThrowsAnException(){
        //Give
        var list = mock(List.class);
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar"));

        //When
        //Then
        assertThrows(RuntimeException.class, () ->list.get(anyInt()), ()-> "Should throw RuntimeException");


    }
}
