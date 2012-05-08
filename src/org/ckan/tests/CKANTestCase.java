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
        Client c = new Client( new Connection() );
        //Dataset ds = c.LoadClass( Dataset.class, "{title:\"Testing\"}" );
        //System.out.println(ds);
    }

    @Test
    public void test_BasicGroup_Local() {
    }


 public static String loadString(File file) {
    try{
      int len;
      char[] chr = new char[4096];
      final StringBuffer buffer = new StringBuffer();
      final FileReader reader = new FileReader(file);
      try {
          while ((len = reader.read(chr)) > 0) {
              buffer.append(chr, 0, len);
          }
      } finally {
          reader.close();
      }
      return buffer.toString();
  } catch ( IOException ioe) {
    System.out.println(ioe);
  }
  System.out.println("eerk");
  return "";
  }

}


