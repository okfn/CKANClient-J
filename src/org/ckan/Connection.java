package org.ckan;

import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;


/**
 * Connection holds the connection details for this session
 *
 * @author      Ross Jones <ross.jones@okfn.org>
 * @version     1.7
 * @since       2012-05-01
 */
public final class Connection {

    private String m_host;
    private int m_port;
    private String _apikey = null;

    public Connection(  ) {
        this("http://datahub.io", 80);
    }

    public Connection( String host  ) {
        this( host, 80 );
    }

    public Connection( String host, int port ) {
        this.m_host = host;
        this.m_port = port;

        try {
            URL u = new URL( this.m_host + ":" + this.m_port + "/api");
        } catch ( MalformedURLException mue ) {
            System.out.println(mue);
        }

    }

    public void setApiKey( String key ) {
        this._apikey = key;
    }

    protected String Post(String path, String data)
        throws CKANException {
        URL url = null;

        try {
            url = new URL( this.m_host + ":" + this.m_port + path);
        } catch ( MalformedURLException mue ) {
            System.err.println(mue);
            return null;
        }

        String body = "";
        try {
            String vars = URLEncoder.encode(data, "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8");
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("X-CKAN-API-Key", this._apikey);
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(vars);
            wr.flush();

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                body += line;
            }
            wr.close();
            rd.close();
        } catch ( java.io.IOException ioe ) {
            throw new CKANException( ioe.toString() );
        } catch (Exception e) {
            throw new CKANException( e.toString() );
        }

        return body;
    }

}






