Camel Project for Blueprint 
=========================================
Leer de un archivo xml que contiene el nombres y apellidos, nombre del curso y las notas de los estudiantes por cortes,
si el promedio de las notas es superior a 3.0 envíar calificación del 
estudiante como aprobado, si es superior a 4.5 enviar mensaje de felicitacion,
en ambos casos se debe enviar nombre, curso y calificación del estudiante. Salida en formato xml.
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
