package org.ckan;


/**
 * Connection holds the connection details for this session
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.0
 * @since       2012-05-01
 */
public final class Connection {

    private String m_host;
    private int m_port;

    public Connection(  ) {
        this("datahub.io", 80);
    }

    public Connection( String host  ) {
        this( host, 80 );
    }

    public Connection( String host, int port ) {
        this.m_host = host;
        this.m_port = port;
    }

}






