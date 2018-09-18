package org.jrm.sorting;

import java.util.Comparator;
import java.util.Map;

/**
 * JComparator class used to override default sorting behavior of a Tree Map
 * @author Jared Mallas
 * @version 1.0
 */
public class JComparator implements Comparator<String>
{
    Map<String, Integer> base;

    /**
     * Constructor
     * @param base hash map
     */
    public JComparator(Map<String, Integer> base)
    {
        this.base = base;
    }

    /**
     * Override of compare method
     * @param a Thing to compare
     * @param b Other thing to compare
     * @return 1/-1 for comparison
     */
    public int compare(String a, String b)
    {
        if (base.get(a) >= base.get(b)) { return -1; }
        else { return 1; }
    }
}
