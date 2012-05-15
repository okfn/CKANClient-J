package org.ckan.tests;


import org.junit.* ;
import static org.junit.Assert.* ;

import org.ckan.*;

import com.google.gson.Gson;

import java.util.UUID;

public class DeleteTestCases {

    @Test
    public void test_DeleteDataset() {
        Client c = new Client( new Connection("http://localhost", 5000),
                              "1de4a922-732d-40ad-8169-abd3d5d0e196");
        try {
            Dataset ds = new Dataset();
            ds.setName( UUID.randomUUID().toString() );
            ds.setTitle("Test Dataset");
            ds.setNotes("A description");
            Dataset result = c.createDataset(ds);

            c.deleteDataset(result.getId());
        } catch ( CKANException e ) {
            System.out.println(e);
        }
    }

    @Test
    public void test_DeleteDatasetNoAuth() {
        Client c = new Client( new Connection("http://localhost", 5000),
                              "invalid");
        try {
            Dataset ds = new Dataset();
            ds.setName( UUID.randomUUID().toString() );
            ds.setTitle("Test Dataset");
            ds.setNotes("A description");
            Dataset result = c.createDataset(ds);

            c.deleteDataset(result.getId());
            assertTrue( false );
        } catch ( CKANException e ) {
            assertEquals(2, e.getErrorMessages().size());
        }
    }


}


