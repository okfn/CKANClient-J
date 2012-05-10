package org.ckan;


import com.google.gson.Gson;

import java.util.Map;
import java.util.HashMap;

/**
 * The primary interface to this package the Client class is responsible
 * for managing all interactions with a given connection.
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public final class Client {

    public class Response {
        public String success;
    }

    private Connection _connection = null;

    public Client( Connection c, String apikey ) {
        this._connection = c;
        this._connection.setApiKey(apikey);
    }

    protected <T> T LoadClass( Class<T> cls, String data ) {
        Gson gson = new Gson();
        return gson.fromJson(data, cls);
    }

    private void HandleError( String json, String action )
          throws CKANException {
        CKANException exception = new CKANException("Errors occured performing: " + action);

        HashMap hm  = LoadClass( HashMap.class, json);
        Map<String,Object> m = (Map<String,Object>)hm.get("error");
        for (Map.Entry<String,Object> entry : m.entrySet()) {
            if ( entry.getKey().startsWith("_") )
                continue;
            exception.addError( entry.getValue() + " - " + entry.getKey() );
        }
        throw exception;
    }


    /**
    * Retrieves a dataset
    *
    * Retrieves the dataset with the given name, or ID, from the CKAN
    * connection specified in the Client constructor.
    *
    * @param  name The name or ID of the dataset to fetch
    * @returns The Dataset for the provided name.
    * @throws A CKANException if the request fails
    */
    public Dataset getDatasetByName(String name)
            throws CKANException {
        String returned_json = this._connection.Post("/api/action/package_show",
                                                     "{\"id\":\"" + name + "\"}" );
        Dataset.Response r = LoadClass( Dataset.Response.class, returned_json);
        if ( ! r.success ) {
            HandleError( returned_json, "getDatasetByName");
        }
        return r.result;
    }

    /**
    * Creates a dataset on the server
    *
    * Takes the provided dataset and sends it to the server to
    * perform an create, and then returns the newly created dataset.
    *
    * @param  dataset A dataset instance
    * @returns The Dataset as it now exists
    * @throws A CKANException if the request fails
    */
    public Dataset createDataset(Dataset dataset)
            throws CKANException {
        Gson gson = new Gson();
        String data = gson.toJson( dataset );

        String returned_json = this._connection.Post("/api/action/package_create",
                                                     data );
        Dataset.Response r = LoadClass( Dataset.Response.class, returned_json);
        if ( ! r.success ) {
            // This will always throw an exception
            HandleError(returned_json, "createDataset");
        }
        return r.result;
    }


    /**
    * Retrieves a group
    *
    * Retrieves the group with the given name, or ID, from the CKAN
    * connection specified in the Client constructor.
    *
    * @param  name The name or ID of the group to fetch
    * @returns The Group instance for the provided name.
    * @throws A CKANException if the request fails
    */
    public Group getGroupByName(String name)
            throws CKANException {
        String returned_json = this._connection.Post("/api/action/group_show",
                                                     "{\"id\":\"" + name + "\"}" );
        Group.Response r = LoadClass( Group.Response.class, returned_json);
        if ( ! r.success ) {

        }
        return r.result;
    }

}






