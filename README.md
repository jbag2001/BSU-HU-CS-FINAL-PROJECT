# BSU-HU-CS-310-JDBC-Setup
This repo contains code that can be used to test your JDBC setup.

## Compile Java
``cd src``

``make``

## Setup
Add the following to your CLASSPATH on onyx. 
````
export CLASSPATH=/opt/mysql/mysql-connector-java-5.1.45/mysql-connector-java-5.1.45-bin.jar:$CLASSPATH
````

Export the environment variables in your shell prior to running.
````
export MYSQL_DATABASE=yourDatabaseName
export MYSQL_HOST=localhost
export MYSQL_USERNAME=msandbox
export MYSQL_PASSWORD=yourPassword
````


## Run test
``java MySqlDatabase``