package org.ckan;

import java.util.Map;
import java.util.HashMap;

public class CTest {


    public static void main(String[] args ){
        System.out.println("Hello World");

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title", "The title goes here");
        map.put("type", "Dataset");
        map.put("author", "Ross Jones");

        Dataset d = new Dataset();
        d.Load( map );

        System.out.println( d.toString() );
    }
}