# GestionInscription-EJB-WEB-EAR
# Structure du projet

Ce projet est une application Java EE qui utilise les technologies EJB, Web et EAR. Il est conçu pour être exécuté sur un serveur d'applications JEE tel que JBoss.
## Arborescence des dossiers

Le projet est organisé en trois modules :

### Module EJB

Le module EJB contient les classes qui implémentent les composants d'entreprise de l'application. Il comprend les sous-dossiers suivants :

- meta-inf: Contient un fichier très important qui est le persistence.xml où nous avons defini notre datasource déja configuré grace à wildfly 27 et notre persistence unit.

- ejbmodules: Contient les packages sn.isi.dao et sn.isi.entities.
Dans DAO on a les interfaces et les classes d'implémentations et dans ENTITIES on a les entités.

### Module Web

Le module Web contient les pages Web et les contrôleurs pour l'application. Il comprend les sous-dossiers suivants :

- src/main/webapp: Contient les pages JSP et les fichiers statiques tels que les fichiers CSS et JavaScript.
- src/main/java/controller: Contient les sources Java pour les contrôleurs Web.

### Module EAR

Le module EAR est le module principal qui relie les modules EJB et Web ensemble.


## Construction du projet
Une fois que l'EAR est construit, vous pouvez le déployer sur un serveur d'applications JEE. Consultez la documentation de votre serveur d'applications pour savoir comment déployer un fichier EAR.

Après le déploiement, vous pouvez accéder à l'application en utilisant l'URL suivante : Voici la syntaxe README correspondant à la réponse que j'ai donnée :

vbnet
Copy code
# Structure du projet

Ce projet est une application Java EE qui utilise les technologies EJB, Web et EAR. Il est conçu pour être exécuté sur un serveur d'applications JEE tel que JBoss ou GlassFish.

## Arborescence des dossiers

Le projet est organisé en trois modules :

### Module EJB

Le module EJB contient les classes qui implémentent les composants d'entreprise de l'application. Il comprend les sous-dossiers suivants :

- src/main/java: Contient les sources Java pour les classes EJB.
- src/test/java: Contient les tests unitaires pour les classes EJB.

### Module Web

Le module Web contient les pages Web et les contrôleurs pour l'application. Il comprend les sous-dossiers suivants :

- src/main/webapp: Contient les pages JSP et les fichiers statiques tels que les fichiers CSS et JavaScript.
- src/main/java: Contient les sources Java pour les contrôleurs Web.
- src/test/java: Contient les tests unitaires pour les contrôleurs Web.

### Module EAR

Le module EAR est le module principal qui relie les modules EJB et Web ensemble. Il comprend les sous-dossiers suivants :

- src/main/application: Contient le fichier application.xml qui définit les modules de l'application et leurs relations.
- src/main/resources: Contient les fichiers de configuration de l'application tels que jboss-web.xml et web.xml.

## Construction du projet

Le projet utilise Maven comme système de gestion de build. Pour construire l'application, exécutez la commande suivante à la racine du projet :

mvn clean package

rust
Copy code

Cela va construire les modules EJB et Web, puis créer le fichier EAR qui peut être déployé sur un serveur d'applications.

## Exécution de l'application

Une fois que l'EAR est construit, vous pouvez le déployer sur un serveur d'applications JEE. Consultez la documentation de votre serveur d'applications pour savoir comment déployer un fichier EAR.

Après le déploiement, vous pouvez accéder à l'application en utilisant l'URL suivante :

http://localhost:8080/WebGestionInscription


