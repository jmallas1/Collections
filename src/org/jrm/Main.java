package org.jrm;

import org.jrm.io.FileInput;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static FileInput indata = new FileInput("the_book.csv");
    private final static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void main(String[] args)
    {
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