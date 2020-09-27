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
export CS310_DATABASE=yourDatabaseName
export CS310_HOST=localhost #or remotemysql.com
export CS310_PORT=8033
export CS310_USERNAME=msandbox
export CS310_PASSWORD=yourPassword
````

NOTE: you can put these in your bashrc file ``~/.bashrc``

## Run test
``java CheckDatabaseDriverSetup``

or

``make run``
