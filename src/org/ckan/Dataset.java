package org.ckan;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Map;

/**
 * Represents a CKAN Dataset (previously a Package)
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public final class Dataset extends CKANObject {

    public String id;
    public String name;
    public String title;
    public String version;
    public URI    url;
    public String author;
    public String author_email;
    public String maintainer;
    public String maintainer_email;
    public String notes;
    public String license_id;
    public String type;
    public Map<String,String> extras;

    /**
    * Called when Load() fails to find a String field to map a given key
    * to, instead the key and value are passed to the concrete instance
    * so that it can decide what to do with the data.
    *
    * @param key The key from the original JSON
    * @param value Normally either a list or a dict of some form
    */
    public void HandleField( String key, Object value ) {
        try {
            switch( key ) {
                case "url":
                    this.url = new URI( value.toString() );
            }
        } catch ( URISyntaxException e ) {
        }
    }


    public String toString() {
        return "<Dataset:" + this.type + ", " + this.title + "," + this.author + ", " + this.url + ">";
    }
}






