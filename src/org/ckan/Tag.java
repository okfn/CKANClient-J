package org.ckan;

/**
 * Represents a tag
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public class Tag {

    private String vocabulary_id;
    private String display_name;
    private String name;
    private String id;

    public String getVocabulary_id() { return vocabulary_id; }
    public void setVolcabulary_id(String v) { vocabulary_id = v; }

    public String getDisplay_name() { return display_name; }
    public void setDisplay_name(String d) { display_name = d; }

    public String getName() { return name; }
    public void setName(String n) { name = n; }

    public String getId() { return id; }
    public void setId(String v) { id = v; }

    public Tag() {}
}