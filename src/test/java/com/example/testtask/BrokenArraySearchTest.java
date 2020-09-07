package com.example.testtask;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class BrokenArraySearchTest {

    @Test
    void testFindElem() {
        BrokenArraySearch search = new BrokenArraySearch();
        int[] arr = new int[] {5, 6, 1, 2, 3, 4};

        assertEquals(2, search.findElem(arr,1));
        assertEquals(1, search.findElem(arr,6));
        assertEquals(4, search.findElem(arr,3));

        assertEquals(0, search.findElem(arr,5));
        assertEquals(5, search.findElem(arr,4));
        assertEquals(-1, search.findElem(arr,9));
    }
}