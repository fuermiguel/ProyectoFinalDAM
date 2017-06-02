# ProyectoFinalDAM
Proyecto final del ciclo superior DAM

Aplicación de ayuda a la gestión de oficina técnicas. 

-  Son plantillas de diferentes proyectos(Planes de emergencias, piscinas, reformas, etc).

-  Solo está implementada la plantilla de Planes de emergencias.

-  La información de la plantilla(formulario) se almacenará en la base de datos Couchbase Lite

-  Puede funcionar en modo offline y sincronizarse posteriormente cuando esté online.

-  La infraestructura necesaria es el dispositivo movil y un servidor con la misma base de datos en este caso 
    la server y otro componente que hace la sincronización Sync Gateway. (Como se configuran se encuentra en el wiki)
    
-  La parte cliente web se encuentra en el repositorio ProyectoNodeDAM


