JCKANClient
====

__A work in progress__

Provides an interface to a [CKAN 1.7](http://ckan.org) installation.

An [ant](http://ant.apache.org/) build.xml file is provided with the source code, and the following tasks are implemented:

__Install Dependencies__

Run the following to install dependencies (gson 2.2 and junit 4.10 and apache.httpclient 4.1.3) locally

```
ant deps
```

__Generate documentation__

Documentation is generated in the docs folder.

```
ant docs
```

__Run tests__

```
APIKEY=_YOUR-API-KEY-HERE_ ant test
```

USAGE
-----

A simple example of using the API is show below, this particular one will search for all 'gold' related datasets on [datahub.io](http://datahub.io) and display information about the resources attached to each one.

```java
    public void test_Example() {
        // Create a new client with a connection to datahub.io, on the default
        // port and with no api key required.
        Client client = new Client( new Connection("http://datahub.io"), "");

        try {
            // Get the search results for the word gold
            Dataset.SearchResults search_results = client.findDatasets("gold");
            for (Dataset dataset : search_results.results ) {
                int count = 0;

                System.out.println("Adding resources from " + dataset.getTitle() + "\n");
                for (Resource resource : dataset.getResources() ) {
                    count = count + 1;
                    System.out.println( " " + count + ". "  + resource.getName() );
                    System.out.println( "    Format: "      + resource.getFormat() );
                    System.out.println( "    Mimetype: "    + resource.getMimetype() );
                    System.out.println( "    Description: " + resource.getDescription() );
                    System.out.println( "    URL: "         + resource.getUrl() + "\n");
                }
                System.out.println("");
            }
        } catch ( CKANException e ) {
            System.out.println(e);
        }
    }

```

Which with the current data should show:


```
Adding resources from Gold Prices in London 1950-2008 (Monthly)

 1. CSV
    Format: csv
    Mimetype: text/plain
    Description: CSV file extracted and cleaned from source excel
    URL: https://raw.github.com/datasets/gold-prices/master/data/data.csv

Adding resources from Gold & Silver Mines Energy Use & GHG Emissions 

   1. null
      Format: XLS
      Mimetype: null
      Description: Gold and Silver Mines Secondary Energy Use and GHG Emissions
      URL: http://oee.nrcan.gc.ca/corporate/statistics/neud/dpa/tablestrends2/id_ca_11_e.xls

   2. null
      Format: html
      Mimetype: null
      Description:
      URL: http://oee.nrcan.gc.ca/corporate/statistics/neud/dpa/tablestrends2/id_ca_11_e_4.cfm?attr=0

Adding resources from Open Economics Data Store

   1. null
      Format: index/html
      Mimetype: null
      Description: Data store index page
      URL: package-type.catalog

Adding resources from Standard and Poor's (S&P) 500 Monthly Market Data including Price, Dividend, Earnings and P/E Ratio

   1. standard-and-poors-500-shiller.webstore.csv
      Format: csv
      Mimetype: text/csv
      Description: Webstore version of file (cleaned up and normalized)
      URL: http://webstore.thedatahub.org/rufuspollock/standard-and-poors-500-shiller/data.csv

   2. irrational_exuberance_data.xls
      Format: xls
      Mimetype: application/vnd.ms-excel
      Description: Source excel file on Robert Shiller's website (updated monthly)
      URL: http://www.econ.yale.edu/~shiller/data/ie_data.xls

   3. git-repo
      Format: git
      Mimetype: null
      Description: Source repo with relevant scripts.
      URL: https://github.com/rgrp/dpkg-standard-and-poors-500-shiller

```


TODO
----

 * Non-dataset/group/resource objects

