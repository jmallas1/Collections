package org.jrm;

import org.jrm.io.FileInput;
import org.jrm.sorting.JComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Main class and methods for demonstrating collection sorting and counting.
 * @author Jared Mallas
 * @version 1.0
 */
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

        int counter = 0;
        String topOutString = new String();
        ArrayList<String> oneList = new ArrayList<String>();

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
        {
            if (counter < 100)
            {
                topOutString = topOutString + entry.getKey() + "\t-\t" + entry.getValue().toString() + "\n";
                counter++;
            }

            if(entry.getValue() == 1)
            {
                oneList.add(entry.getKey());
            }
        }

        System.out.println("The top 100 most used words and their values:\n" + topOutString);
        System.out.println("The following " + oneList.size() + " words were only used once: \n" + oneList);
    }

    private static String cleanBook(String toClean)
    {
        toClean = toClean.replace(",","").replace(".","")
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