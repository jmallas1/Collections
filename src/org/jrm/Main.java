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
        theBook = theBook.replace(",","").replace(".","")
                .replace(";","").replace(":","")
                .replace("'","").replace("\"","")
                .replace("-","").replace("!","")
                .replace("#","").replace("(","")
                .replace(")","").replace("?","")
                .replace("_"," ").replace("?","")
                .replaceAll("\n", " ").replaceAll("\\s{2,}", " ")
                .toLowerCase().trim();

        words = theBook.split(" ");

        for (int i=0; i < words.length; i++)
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

        sortedMap.putAll(map);

        System.out.println(theBook);
    }

    public static void main2(String[] args) {
        String line;
        String[] words;
        Object wordFound;
        //   String[] fields;

        while ((line = indata.readLine()) != null) {
            line=line.replace(",","").replace(".","")
                    .replace(";","").replace(":","")
                    .replace("'","").replace("\"","")
                    .replace("-","").replace("!","")
                    .replace("#","").replace("(","")
                    .replace(")","").replace("?","")
                    .replace("_"," ").replace("?","")
                    .toLowerCase().trim();
            words = line.split(" ");
            for (String s:words) {
                wordFound = map.get(s);
                if (wordFound == null) {
                    map.put(s, new Integer(1));
                }
                else {
                    map.put(s, map.get(s) + 1);
                }

            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

}