package org.jrm;

import org.jrm.io.FileInput;
import org.jrm.sorting.JComparator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();
    private final static JComparator jc = new JComparator(map);
    private final static TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(jc);

    public static void main(String[] args)
    {
        String[] words;
        String theBook = indata.readFile();
        theBook = cleanBook(theBook);

        words = theBook.split(" ");

        for (int i=0; i < words.length; i++)
        {
            if (! words[i].equals(""))
            {
                if(map.containsKey(words[i]))
                {
                    map.put(words[i], (map.get(words[i]) + 1));
                }
                else
                {
                    map.put(words[i], 1);
                }
            }
        }

        sortedMap.putAll(map);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
        {
            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue().toString());
        }
    }

    private Map wordsToMap(String[] words)
    {
        return new HashMap();
    }

    private static String cleanBook(String toClean)
    {
        toClean.replace(",","").replace(".","")
                .replace(";","").replace(":","")
                .replace("'","").replace("\"","")
                .replace("-","").replace("!","")
                .replace("#","").replace("(","")
                .replace(")","").replace("?","")
                .replace("_"," ").replace("?","")
                .replaceAll("\n", " ").replaceAll("\\s{2,}", " ")
                .toLowerCase().trim();

        return toClean;
    }
}