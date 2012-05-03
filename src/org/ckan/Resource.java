package org.ckan;

import java.net.URI;
import java.util.Date;

/**
 * Represents a single resource within a Dataset
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public final class Resource extends CKANObject {

    public String id;
    public String resource_group_id;
    public URI    url;
    public String format;
    public String name;
    public String description;
    public String hash;
    public int position;
    public String resource_type;
    public String mimetype;
    public String mimetype_inner;
    public int    size;
    public Date   created;
    public String last_modified;
    public URI    cache_url;
    public Date   cache_last_updated;
    public URI    webstore_url;
    public Date   webstore_last_updated;

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






