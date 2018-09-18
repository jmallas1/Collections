package org.jrm.sorting;

import java.util.Comparator;
import java.util.Map;

public class JComparator implements Comparator<String>
{
    Map<String, Integer> base;

    public JComparator(Map<String, Integer> base)
    {
        this.base = base;
    }

    public int compare(String a, String b)
    {
        if (base.get(a) >= base.get(b)) { return -1; }
        else { return 1; }
    }
}
