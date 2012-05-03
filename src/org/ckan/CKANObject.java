package org.ckan;

import java.util.Date;
import java.util.Map;

import java.lang.reflect.*;

/**
 * Base class for objects originating from CKAN servers, generally
 * populated from the retrieved JSON
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-03
 */
public abstract class CKANObject {

    /**
    * Load the provided map into the fields of this class, asking the class
    * what it wants to do with non-string fields.
    *
    * @param obj The key-value map which contains the data from a JSON
    *            file
    */
    public void Load( Map<String, Object> obj ) {
        Class clazz = this.getClass();
        for (Map.Entry<String,Object> entry : obj.entrySet() ) {
            try {
                Field f = clazz.getDeclaredField( entry.getKey() );
                Class cls = f.getType();

                if ( cls == "".getClass() ) {
                    f.set( this, entry.getValue() );
                } else {
                    this.HandleField( entry.getKey(), entry.getValue() );
                }

            } catch ( NoSuchFieldException nsfe ) {
                // Do nothing here, we can't find the field
            } catch ( IllegalAccessException iae ) {
                // Do nothing here, we can't write to this field
            }
        }
    }

    /**
    * Called when Load() fails to find a String field to map a given key
    * to, instead the key and value are passed to the concrete instance
    * so that it can decide what to do with the data.
    *
    * @param key The key from the original JSON
    * @param value Normally either a list or a dict of some form
    */
    public abstract void HandleField( String key, Object value );

}






