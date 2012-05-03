package org.ckan;


/**
 * The primary interface to this package the Client class is responsible
 * for managing all interactions with a given connection.
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public final class Client {

    private Connection _connection = null;

    public Client( Connection c ) {
        this._connection = c;
    }

}






