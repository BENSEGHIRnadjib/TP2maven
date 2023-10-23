[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/YVvOaTPu)

TP 2 BENSEGHIR Nadjib Eddine Adib M1AMIS 22301396
# TP Maven-JUnit
L'objet de cet exercice est de réaliser une classe `ChaineCryptee` qui permettra de chiffrer/déchiffrer une chaîne de caractères (**composée de lettres majuscules et d'espace**).
Le chiffrement utilise une méthode par décalage.
La valeur du décalage représente la clé de chiffrement.
Par exemple, une clé de valeur trois transformera un `'A'` en `'D'`.

La classe `ChaineCryptee` disposera
* des attributs pour la chaîne *en clair* et le décalage,
* un constructeur pour initialiser les instances à partir d'une chaîne en clair et du décalage,
* la méthode `String decrypte()` qui retourne la chaîne en clair,
* la méthode `String crypte()` qui retourne la chaîne chiffrée,
Vous pourrez utilisez pour cela la [méthode `decaleCaractere`](https://gist.github.com/hal91190/4f3a0941e652e82a5e1c572834d97827),
* la possibilité d'initialiser une instance à partir d'une chaîne cryptée et d'un décalage.
Pour éviter l'ambiguïté au niveau du constructeur, vous utiliserez le [modèle de conception Fabrication](http://fr.wikipedia.org/wiki/Fabrique_%28patron_de_conception%29#Autres_avantages_et_variantes).
Pour cela,
    * créez les méthodes de classe `ChaineCryptee deCryptee(String, int)` et `ChaineCryptee deEnClair(String, int)`,
    * rendez le constructeur privé.
La création des instances se fait maintenant à l'aide des deux méthodes de classe.

De plus, le projet sera géré avec [Maven](https://maven.apache.org/) et vous utiliserez une approche pilotée par les tests pour la réalisation, i.e. écrivez toujours un test avant le code et pensez au refactoring.
Le framework de tests devra être [JUnit 4](https://junit.org/junit4/) (ou [5](https://junit.org/junit5/) si vous préférez).
Vous rédigerez votre code source en respectant les [conventions de codage](https://google.github.io/styleguide/javaguide.html) du guide de stype _Google_.
Enfin, la prise en compte des contraintes se fera par de la gestion d’erreurs et des exceptions.

Il pourra éventuellement être nécessaire de [configurer le proxy](http://maven.apache.org/guides/mini/guide-proxies.html) (http://wwwcache.uvsq.fr:3128) pour accéder au dépôt Maven.

À chaque étape, validez vos modifications avec `git` et si nécessaire, exécutez le cycle maven adapté pour vérifier vos manipulations.

1.  Quelles conventions utilise Maven pour l’arborescence des répertoires ?
    > Maven utilise des conventions d'arborescence pour organiser les fichiers d'un projet Java. Les principales sont :
     src/main/java: Contient les fichiers source Java principaux.
     src/main/resources: Stocke les ressources non Java.
     src/test/java: Pour les fichiers source des tests unitaires.
     src/test/resources: Contient les ressources spécifiques aux tests.
   
1.  Examinez le projet Maven ainsi que le fichier de description et répondez aux questions suivantes :
    1.  Dans quel répertoire se trouvent les fichiers sources du projet ? Les sources des tests ?
    Les fichiers sources du projet sont répartis entre deux répertoires : le code source principal se trouve dans le dossier src/main/java/fr.uvsq.cprog.mvnjunit, tandis que les sources des tests se trouvent dans le répertoire src/test/java/fr.uvsq.cprog.mvnjunit.

    Les coordonnées du projet sont définies dans le fichier pom.xml, à travers les balises groupId, artifactId et version :

    groupId : fr.uvsq.cprog
    artifactId : mvnjunit
    version : 1.0-SNAPSHOT
    La propriété project.build.sourceEncoding sert à spécifier l'encodage (charset) utilisé pour les fichiers sources du projet. Dans ce cas, l'encodage est défini comme UTF-8.

    Les versions des sources Java et de la JVM sont définies dans les propriétés <maven.compiler.source> et <maven.compiler.target> :

   maven.compiler.source : 1.7
   maven.compiler.target : 1.7
   La version de JUnit configurée est 4.11. La balise <scope> est définie comme "test", ce qui signifie que JUnit sera utilisé uniquement pour les tests unitaires pendant la phase de test de Maven. Voici l'exemple de la dépendance JUnit configurée dans le fichier pom.xml :

   xml
   Copy code
   <dependency>
   <groupId>junit</groupId>
   <artifactId>junit</artifactId>
   <version>4.11</version>
   <scope>test</scope>
   </dependency>
    Cela signifie que JUnit 4.11 sera utilisé uniquement lors de l'exécution des tests unitaires et ne fera pas partie des dépendances du projet principal.
        
    1. Quelles sont les coordonnées du projet ?
        > 
       Les coordonnées du projet dans le fichier pom.xml sont les suivantes :

        groupId: fr.uvsq.cprog (groupe du projet).
        artifactId: mvnjunit (nom unique du projet).
        version: 1.0-SNAPSHOT (version du projet).
        
    1. À quoi sert la propriété `project.build.sourceEncoding` ?
        > project.build.sourceEncoding dans Maven spécifie l'encodage des caractères utilisé lors de la compilation des fichiers source, essentiel pour traiter correctement les 
          caractères spéciaux et non ASCII. Par défaut, il est généralement défini sur "UTF-8" pour prendre en charge une large gamme de caractères.
        
    1. Quelles versions des sources et de la JVM sont utilisés ?
        >  <maven.compiler.source>: La version source Java utilisée est 1.7.
           <maven.compiler.target>: La version de la JVM cible est également 1.7.
        
    1. Quelle version de JUnit est configurée ? À quoi sert la balise `scope` ?
        > Dans le fichier pom.xml que vous avez fourni, la version de JUnit configurée est la version 4.11. Cela est indiqué dans la balise <version> sous la dépendance JUnit.
          La balise <scope> est utilisée pour spécifier la portée (scope) d'une dépendance dans Maven. Dans cet exemple, la dépendance JUnit a la portée test. Cela signifie que les 
          classes JUnit ne seront disponibles que pour la phase de test de construction de votre projet, et elles ne seront pas incluses dans le JAR ou le produit final généré lorsque 
          vous construisez et déployez votre application. Cette portée est couramment utilisée pour les dépendances de tests unitaires, car elles ne sont nécessaires que pour 
          l'exécution des tests et ne devraient pas être incluses dans l'application déployée.
        
    1. À quoi sert la section `pluginManagement` ?
        > La section <pluginManagement> dans un fichier pom.xml de Maven est utilisée pour centraliser et gérer les configurations par défaut des plugins, y compris les versions des 
         plugins, pour un projet multi-modules. Elle garantit des configurations de plugins cohérentes entre les modules du projet et simplifie les mises à jour de versions en 
         spécifiant les versions des plugins en un seul endroit, généralement dans le POM parent.
        > 
1.  Modifiez la configuration du projet de la façon suivante :
    1.  fixez la version des sources et des .class pour utiliser la version 17 de Java
    1.  utilisez la dernière version stable de JUnit 4 (cf. [MVNRepository](https://mvnrepository.com/))
1.  Ajoutez un fichier `.gitignore` adapté aux projets Maven (cf. [A collection of .gitignore templates](https://github.com/github/gitignore)) et ajoutez-y les fichiers et répertoires de votre IDE.
1.  Quelle commande Maven permet de :
    1.  créer un `jar` du projet ?
        > Pour créer un fichier JAR à partir d'un projet Maven, vous pouvez utiliser la commande mvn package. Cette commande compile le projet et génère un fichier JAR dans le dossier 
          target, prêt à être utilisé ou distribué.
        
    1. lancer les tests ?
        > mvn test
    1. supprimer tous les fichiers issus de la compilation ?
        > mvn clean
  
1.  Ajoutez une classe `ChaineCryptee` et une classe `ChaineCrypteeTest` dans les répertoires et packages appropriés.
    Supprimez les classes d'exemple `App` et `AppTest`.
1.  Énumérez une liste de cas de tests à réaliser en n'oubliant pas les cas d'erreur.
    > Cas de test pour crypte() :
/ Crypter une chaîne vide avec un décalage nul.
/ Crypter une chaîne non vide avec un décalage nul.
/ Crypter une chaîne avec un décalage positif.
/ Crypter une chaîne avec un décalage négatif.
/ Crypter une chaîne contenant des caractères spéciaux (ignorer les caractères spéciaux).

> Cas de test pour decrypte() :
/ Décrypter une chaîne vide avec un décalage nul.
/ Décrypter une chaîne non vide avec un décalage nul.
/ Décrypter une chaîne avec un décalage positif.
/ Décrypter une chaîne avec un décalage négatif.
/ Décrypter une chaîne contenant des caractères spéciaux (ignorer les caractères spéciaux).
/ Cas de test pour les méthodes de création (decrypt() et encrypt()).

> Cas d'erreur :
 Crypter ou décrypter une chaîne avec un décalage supérieur à 26.

1.  Pour chaque cas de test,
    1. écrivez le test JUnit correspondant dans la classe de test,
    1. vérifiez qu’il échoue,
    1. implémentez la fonctionnalité dans la classe,
    1. vérifiez que le test passe,
    1. appliquez un étape de refactoring sur les tests et la classe si nécessaire.
1.  Comment se comporte votre classe si la chaîne passée au constructeur est `null` ?
Vous pouvez utiliser le débogueur pour identifier le problème (s'il y a un problème) au niveau de `crypte`.
    > if (string == null) {
    return null;
    }
    1. ajoutez un test pour prendre en compte la chaîne `null`,
    1. si nécessaire, modifiez la classe pour faire passer le test
1. Changez la représentation interne de la classe : seule la chaîne cryptée est stockée (plus la chaîne en clair).
    * effectuez les modifications nécessaires sans changer l'interface de la classe (les tests ne seront donc pas impactés).
1.  Modifiez le POM pour intégrer la vérification des conventions de codage avec [`checkstyle`](http://maven.apache.org/plugins/maven-checkstyle-plugin/) en utilisant les conventions _Google_.
1.  Ajoutez une méthode `main` qui démontre quelques fonctionnalités de la classe, puis modifiez le POM pour que le jar généré soit exécutable (cf. [Apache Maven JAR Plugin](https://maven.apache.org/plugins/maven-jar-plugin/index.html))
1.  Modifiez la méthode `main` pour que les différents affichages se fassent à l'aide de la bibliothèque de logging [`SLF4J`](http://www.slf4j.org/)
1. En utilisant le plugin [assembly](https://maven.apache.org/plugins/maven-assembly-plugin/) (ou le plugin [shade](https://maven.apache.org/plugins/maven-shade-plugin/)), générez une archive du projet contenant ses dépendances (uber-jar)
