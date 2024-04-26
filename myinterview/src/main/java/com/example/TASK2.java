package com.example;

import java.util.LinkedList;
import java.util.List;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 */
public class TASK2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Element 1");
        list.add("Element 2");
        list.add("Element 3");
        list.add("Element 4");
        list.add("Element 5");

        _removeMiddleElement(list);
    }

    private static void _removeMiddleElement(List<String> list) {
        System.out.println("Original List: " + list);

        if (list.size() <= 1) {
            System.out.println("This list is too small.");
            return;
        }

        int middleIndex = (list.size() - 1) / 2;

        String removedElement = list.remove(middleIndex);

        System.out.println("List after removing the middle element: " + list);
        System.out.println("\n" +"Element Removed: " + removedElement);

    }
}

