# GestionInscription-EJB-WEB-EAR
# Structure du projet

Ce projet est une application Java EE qui utilise les technologies EJB, Web et EAR. Il est conçu pour être exécuté sur un serveur d'applications JEE tel que JBoss.
## Arborescence des dossiers

Le projet est organisé en trois modules :

### Module EJB

Le module EJB contient les classes qui implémentent les composants d'entreprise de l'application. Il comprend les sous-dossiers suivants :

- meta-inf: Contient un fichier très important qui est le persistence.xml où nous avons defini notre datasource déja configuré grace à wildfly 27 et notre persistence unit.

Code:

```
<?xml version="1.0" encoding="UTF-8"?>

<persistence version="2.0" xmlns="http://java.sun.com/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd ">
  
  <persistence-unit name="GestionInscription_UP" transaction-type="JTA">
  	
    <jta-data-source>java:/MySqlDS</jta-data-source>
  	
    <properties>
  		
      <property name="hibernate.hbm2ddl.auto" value="update"/>
  	
    </properties>
  
  </persistence-unit>

</persistence>
```

- ejbmodules: Contient les packages sn.isi.dao et sn.isi.entities.
Dans DAO on a les interfaces et les classes d'implémentations et dans ENTITIES on a les entités.

### Module Web

Le module Web contient les pages Web et les contrôleurs pour l'application. Il comprend les sous-dossiers suivants :

- src/main/webapp: Contient les pages JSP et les fichiers statiques tels que les fichiers CSS et JavaScript.
- src/main/java/controller: Contient les sources Java pour les contrôleurs Web.

### Module EAR

Le module EAR est le module principal qui relie les modules EJB et Web ensemble.


## Construction du projet

Il faut ajouter mettre le projet web et ejb dans le EAR. Ce dernier pourra être déployé sur un serveur d'applications.

## Exécution de l'application

Une fois que l'EAR est construit, vous pouvez le déployer sur un serveur d'applications JEE. Consultez la documentation de votre serveur d'applications pour savoir comment déployer un fichier EAR.

Après le déploiement, vous pouvez accéder à l'application en utilisant l'URL suivante :

http://localhost:8080/WebGestionInscription
