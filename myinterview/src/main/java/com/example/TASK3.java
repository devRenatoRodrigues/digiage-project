package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct items exists on the list.
 *
 */
public class TASK3 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("Element 1");
        stringList.add("Element 2");
        stringList.add("Element 3");
        stringList.add("Element 1");

        System.out.println("Original list: " + stringList);

        int distinctItemCount = countDistinctItems(stringList);

        System.out.println("Distinct items: " + distinctItemCount);
    }

    public static int countDistinctItems(List<String> list) {
        Set<String> distinctItems = new HashSet<>(list);
        return distinctItems.size();
    }
}
