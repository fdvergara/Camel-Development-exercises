Camel Project for Blueprint 
=========================================
Objetivo de la ruta

Leer archivo CSV usando el componente file concatenar datos por medio de un metodo. mostrar la salida en consola. Hacer pruebas unitarias. 
=========================================

To build this project use

    mvn install

To run the project you can execute the following Maven goal

    mvn camel:run

To deploy the project in OSGi. For example using Apache Karaf.
You can run the following command from its shell:

    osgi:install -s mvn:com.mycompany/camel-blueprint/1.0.0-SNAPSHOT

For more help see the Apache Camel documentation

    http://camel.apache.org/
    
 
