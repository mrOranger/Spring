# Spring e Spring Boot
Questa repository contiene degli esempi su Spring e Spring Boot, fatti personalmente dopo aver seguito il corso https://www.udemy.com/course/spring-e-spring-boot-la-guida-completa/ sulla piattaforma di e-learning Udemy. In particolare, questa repository contiene i seguenti esempi:

1.  __Spring Web__ è un'introduzione al framework Spring e Spring Web, con la creazione di una serie di REST controller per operazioni su un Database creato internamente al codice, in particolare,
le operazioni che vengono implementate sono le classiche richieste di un servizio REST.
2. __Spring Data Access__ è un'evoluzione del progetto precedente, con la differenza che questa volta si interagisce con un reale database realizzato con il _DBMS MariaDB_, diversamente dalla versione precedente
il progetto include anche la realizzazione del pattern architetturale DAO, e quindi l'uso del _Dependency Injection_ iniettando l'interfaccia che contiene le operazioni
di accesso al database. Tuttavia, per implementare le operazione sono state scritte manualmente le query da utilizzare ed anche le modalità per mappare il le righe in di una tabella
nella corrispondente classe.
3. __Spring Object Relational Mapping__ completa l'esempio precedente, usando _Hiberante_ per realizzare l'ORM tra l'applicazione ed il Database. Inoltre, viene introdotto il concetto
di repository per astrarre le operazioni di accesso al database.
4. Infine, con __Spring Boot__ realizziamo un esempio più complicato, facendo uso di quello che è stato imparato dalle applicazioni precedenti, ed usando il framework Spring Boot
che configura automaticamente un'applicazione Spring completa di server e di liberie per l'accesso al database e di Hibernate.

Nella repository __Microservices__ realizzeremo dei microservizi con Spring Boot, con un progetto in continuazione su questa riga.
