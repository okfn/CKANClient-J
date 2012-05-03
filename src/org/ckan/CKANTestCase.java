package org.ckan;

import org.junit.* ;
import static org.junit.Assert.* ;

import java.util.Map;
import java.util.HashMap;


public class CKANTestCase {

    @Test
    public void test_BasicDataset_Local() {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title", "The title goes here");
        map.put("type", "Dataset");
        map.put("author", "Ross Jones");

        Dataset d = new Dataset();
        d.Load( map );

        assertTrue(d.title.equals("The title goes here"));
        assertTrue(d.type.equals("Dataset"));
        assertTrue(d.author.equals("Ross Jones"));
    }


}


