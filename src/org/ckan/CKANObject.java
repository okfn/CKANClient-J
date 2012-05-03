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

    public void Load( Map<String, Object> obj ) {
        Class clazz = this.getClass();
        for (Map.Entry<String,Object> entry : obj.entrySet() ) {
            System.out.println("Checking " + entry.getKey());

            try {
                Field f = clazz.getDeclaredField( entry.getKey() );
                Class cls = f.getType();
                if ( cls == "".getClass() ) {
                    f.set( this, entry.getValue() );
                } else {
                    this.PickField( entry.getKey(), entry.getValue() );
                }

            } catch ( NoSuchFieldException nsfe ) {
                // Do nothing here, we can't find the field
            } catch ( IllegalAccessException iae ) {
                // Do nothing here, we can't write to this field
            }
        }
    }

    /**
    * Once the obvious string fields have been processed, the lists and dicts
    * need to be parsed, but these are specific to the object processing them
    * and so it is given a chance to grab those extra fields
    *
    * @param key The key from the original JSON
    * @param value Normally either a list or a dict of some form
    */
    public abstract void PickField( String key, Object value );

}






