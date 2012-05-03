package org.ckan;


/**
 * Represents a single tag on a dataset
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public final class Tag extends CKANObject {

    /**
    * Called when Load() fails to find a String field to map a given key
    * to, instead the key and value are passed to the concrete instance
    * so that it can decide what to do with the data.
    *
    * @param key The key from the original JSON
    * @param value Normally either a list or a dict of some form
    */
    public void HandleField( String key, Object value ) {
        // NOOP
    }


}






