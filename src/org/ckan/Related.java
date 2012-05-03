package org.ckan;

import java.net.URI;
import java.util.Date;

/**
 * Represents a related item on a dataset which
 * shows information about an external item using
 * a dataset
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public final class Related extends CKANObject {

    public String  id;
    public String  type;
    public String  title;
    public String  description;
    public String  owner_id;
    public Date    created;
    public int     view_count;
    public boolean featured;
    public URI     image_url;
    public URI     url;

    /**
    * Called when Load() fails to find a String field to map a given key
    * to, instead the key and value are passed to the concrete instance
    * so that it can decide what to do with the data.
    *
    * @param key The key from the original JSON
    * @param value Normally either a list or a dict of some form
    */
    public void HandleField( String key, Object value ) {

    }

}






