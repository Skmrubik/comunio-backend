Simulador de una aplicación similar a la de Comunio usando microservicios. Uso dos microservicios de Spring Boot que a su vez usan Postgres y MongoDB cada uno de ellos. 
Para la base de datos de MongoDB uso los datos más dinámicos como son las tablas de Puntos y JornadasAcumuladas. Estas tablas inician vacias al empezar la temporada y luego se van rellenando.
A medida que se rellenan tiene que actualizar la base de datos de Postgres y para ello uso Kafka. En la BBDD de Postgres estoy almacenando datos "estaticos" y algunos que cambian a lo largo 
de la temporada (Jugadores, Equipos, Participantes,...). 

Posteriormente, al comprobar que con microservicios funciona bien, se pasa toda la funcionalidad al microservicio que usa Postgres. Esto se hace puesto que en la mensajería con Kafka se pierde cierto
tiempo y solo quería usar microservicios para ver como funcionaban en una aplicación real. 
