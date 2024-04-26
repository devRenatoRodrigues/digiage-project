package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class TASK2Test {

    @Test
    public void testRemoveMiddleElement() throws Exception {
        List<String> list = new LinkedList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        list.add("Element 4");
        list.add("Element 5");

        Method method = TASK2.class.getDeclaredMethod("_removeMiddleElement", List.class);
        method.setAccessible(true);
        method.invoke(null, list);

        assertFalse(list.contains("Element 3"));
        assertEquals(4, list.size());
    }
}
