Camel Project for Blueprint 
=========================================
Leer de un CSV que contiene información de los proyectos que realizan en una empresa, con un codigo, nombre, fecha de la actividad y encargado por parte del cliente.
se requiere tranformar los datos para enviarlos a los sistemas del area de proyectos, desarrollo, scrum master y product owner del proyecto con la siguiente estructura:

proyecto XXXX representado por el codigo xxxx tendra como comienzo el día xx-xx-xx, el encargado por parte del cliente será xx xx xxx
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
