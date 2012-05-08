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
        Gson gson = new Gson();
        Dataset ds = gson.fromJson(loadString(new File("/Users/ross/test.json")), Dataset.class);
        System.out.println( ds );
    }

    @Test
    public void test_BasicGroup_Local() {
        Gson gson = new Gson();
        Group g = gson.fromJson(loadString(new File("/Users/ross/test2.json")), Group.class);
        System.out.println( g );
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


