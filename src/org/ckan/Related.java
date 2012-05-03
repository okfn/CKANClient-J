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
    * Once the obvious string fields have been processed, the lists and dicts
    * need to be parsed, but these are specific to the object processing them
    * and so it is given a chance to grab those extra fields
    *
    * @param key The key from the original JSON
    * @param value Normally either a list or a dict of some form
    */
    public void PickField( String key, Object value ) {

    }

}






