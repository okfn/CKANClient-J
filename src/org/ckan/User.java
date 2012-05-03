package org.ckan;

import java.util.Date;

/**
 * Represents a CKAN User
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public final class User extends CKANObject {

    public String id;
    public String name;
    public String fullname;
    public String email;
    public Date   created;
    public String about;

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






