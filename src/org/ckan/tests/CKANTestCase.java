package org.ckan.tests;


import org.junit.* ;
import static org.junit.Assert.* ;

import org.ckan.*;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CKANTestCase {

    @Test
    public void test_BasicDataset_Local() {
        Client c = new Client( new Connection("http://localhost", 5000), "301ebf50-58a1-45f6-bdc6-0cfb03749cef");
        Dataset ds = c.getDatasetByName( "BjFHjVHqZ73BVquXPwk0lw" );
        System.out.println( ds );
    }

    @Test
    public void test_BasicGroup_Local() {
    }

}


