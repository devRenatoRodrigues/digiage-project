package com.example;


import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

public class TASK3Test {
    @Test
    public void testCountDistinctItems() {
        List<String> stringList = Arrays.asList("Element 1", "Element 2", "Element 3", "Element 1");
        assertEquals(3, TASK3.countDistinctItems(stringList));

        List<String> stringList2 = Arrays.asList("Element 1", "Element 1", "Element 1", "Element 1");
        assertEquals(1, TASK3.countDistinctItems(stringList2));

        List<String> stringList3 = Arrays.asList("Element 1", "Element 2", "Element 3", "Element 4");
        assertEquals(4, TASK3.countDistinctItems(stringList3));
    }
}