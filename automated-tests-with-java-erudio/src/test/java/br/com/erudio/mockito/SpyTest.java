package br.com.erudio.mockito;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    void testV1(){
       //Given
        List<String> mockArrayList = spy(ArrayList.class);
       //When & Then
        assertEquals(0, mockArrayList.size());

        when(mockArrayList.size()).thenReturn(5);

        mockArrayList.add("Foo");
        when(mockArrayList.size()).thenReturn(5);
    }

    @Test
    void testV2(){
        //Given
        List<String> spyArrayList = spy(ArrayList.class);

        //When & Then
        assertEquals(0, spyArrayList.size());

        spyArrayList.add("Foo-Barr");
        assertEquals(1, spyArrayList.size());

        spyArrayList.remove("Foo-Barr");
        assertEquals(0, spyArrayList.size());
    }

    @Test
    void testV3(){
        //Given
        List<String> spyArrayList = spy(ArrayList.class);

        //When & Then
        assertEquals(0, spyArrayList.size());
        when(spyArrayList.size()).thenReturn(5);
        assertEquals(5, spyArrayList.size());
    }

    @Test
    void testV4(){
        //Given
        List<String> spyArrayList = spy(ArrayList.class);
        spyArrayList.add("Foo-Barr");

        //When & Then
        verify(spyArrayList).add("Foo-Barr");
        verify(spyArrayList, never()).remove("Foo-Barr");
        verify(spyArrayList, never()).clear();
    }
}
