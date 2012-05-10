package org.ckan.tests;


import org.junit.* ;
import static org.junit.Assert.* ;

import org.ckan.*;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

public class CreateTestCases {

    @Test
    public void test_CreateDataset() {
        Client c = new Client( new Connection("http://localhost", 5000),
                              "1de4a922-732d-40ad-8169-abd3d5d0e196");
        try {
            Dataset ds = new Dataset();
            ds.setName( UUID.randomUUID().toString() );
            ds.setTitle("Test Dataset");
            ds.setNotes("A description");

            Dataset result = c.createDataset(ds);
        } catch ( CKANException e ) {
            System.out.println(e);
        }
    }

    @Test
    public void test_CreateDatasetFail() {
        Client c = new Client( new Connection("http://localhost", 5000),
                              "1de4a922-732d-40ad-8169-abd3d5d0e196");
        try {
            Dataset ds = new Dataset();
            ds.setName( UUID.randomUUID().toString() );
            ds.setTitle("Test Dataset");
            ds.setNotes("A description");
            c.createDataset(ds);

            c.createDataset(ds);
            assertTrue( false ); // Should have an exception for dupe name
        } catch ( CKANException e ) {
            assertEquals(e.getErrorMessages().size(), 2);
        }
    }


}


