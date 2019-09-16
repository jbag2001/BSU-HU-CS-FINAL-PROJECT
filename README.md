# BSU-HU-CS-310-JDBC-Setup
This repo contains code that can be used to test your JDBC setup.

## Compile Java
``cd src``

``make``

## Setup
 ``
make setup
``

Add the JAR to your classpath

Export the environment variables in your shell prior to running.
````
export MYSQL_DATABASE=yourDatabaseName
export MYSQL_HOST=localhost #or remotemysql.com
export MYSQL_PORT=8033
export MYSQL_USERNAME=msandbox
export MYSQL_PASSWORD=yourPassword
````

NOTE: you can put these in your bashrc file ``~/.bashrc``

## Run test
``java CheckDatabaseDriverSetup``

or

``make run``
