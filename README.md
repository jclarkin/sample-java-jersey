# Sample Glassfish Jersey Project

This is a very simple sample.

* Main.java provides starting the server and stopping (ith dynamic resource configuration)
* MyResource.java provides the Jersey path mapping and responses

Run Main to instantiate a server: ```http://localhost:8084/myapp/```

Responds to GETs on:
* http://localhost:8084/myapp/myresource/
* http://localhost:8084/myapp/myresource/repair/contract

To build the project run ```mvn package``` and to configure Eclipse ```mvn eclipse:eclipse```