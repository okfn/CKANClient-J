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






