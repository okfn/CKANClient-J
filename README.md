JCKANClient
====

__A work in progress__

Currently this lib provides a read-only interface to a [CKAN 1.7](http://ckan.org) installation.

An [ant](http://ant.apache.org/) build.xml file is provided with the source code, and the following tasks are implemented:

__Install Dependencies__

Run the following to install dependencies (gson 2.2 and junit 4.10) locally

```
ant deps
```

__Generate documentation__

Documentation is generated in the doc folder.

```
ant docs
```

__Run tests__

```
ant test
```

TODO
----

 * Support for extras in Dataset/Groups
 * Write support

