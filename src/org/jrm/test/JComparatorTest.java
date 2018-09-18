package org.jrm.test;

import org.jrm.sorting.JComparator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class JComparatorTest {

    HashMap<String, Integer> unsortedMap;
    TreeMap<String, Integer> sortedMap;
    JComparator jc;

    @BeforeEach
    void setUp() {
        unsortedMap = new HashMap<String, Integer>();
        jc = new JComparator(unsortedMap);
        sortedMap = new TreeMap<String, Integer>(jc);

        unsortedMap.put("Emily", 1);
        unsortedMap.put("Darrin", 2);
        unsortedMap.put("Cherise", 3);
        unsortedMap.put("Brittany", 4);
        unsortedMap.put("Alex", 5);
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void compare()
    {
        sortedMap.putAll(unsortedMap);
        assertEquals("Alex", sortedMap.firstKey(), "The first key should be Emily");
        assertEquals("Emily", sortedMap.lastKey(), "The last key should be Alex");
    }
}