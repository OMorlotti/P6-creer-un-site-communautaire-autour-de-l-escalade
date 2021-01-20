## Les amis de l'escalade

*Les amis de l'escalade* est une plateforme communautaire autour du monde de l'escalade, dont l'objectif est la mise en relation et le partage d'informations entre grimpeurs.

### 4 types d'utilisateurs :

  - **Invité** : il n'est pas enregistré en base de données, il n'est donc pas authentifié personnellement.
  Il a accès aux informations sans pouvoir néanmoins les commenter, les partager ou les modifier.
  - **Utilisateur** : il est enregistré en base de données, il est donc authentifié personnellement, peut accéder aux informations, les créer, les commenter et les partager à son tour.
  - **Membre** : cet utilisateur a la particularité d'être membre de l'association *Les amis de l'escalade*. Ses droits comprennent en conséquence ceux de l'utilisateur de précédemment cité, auxquels on ajoute la possibilité taguer un site d'escalade enregistré sur la plateforme comme étant "Officiel *Les amis de l'escalade*", ainsi que la modération des commentaires (modification et suppression).
  - **Administrateur** : il cumule l'ensemble des droits déjà cités auxquels on ajoute des droits sur l'ensemble des informations du site, y compris au sujet des utilisateurs (suppression et modification).

### 8 types d'entités principales :

=> Il s'agit des informations partageables.

Chaque entité est représentée et initialisée dans une classe du même nom.

  - **Utilisateur**
  - **Topo**
  - **Spot**
  - **Secteur**
  - **Voie**
  - **Longueur**
  - **Cotation**
  - **Réservation**

### 2 types d'entités secondaires :

  - **Adresse**
  - **Commentaire**

Le code-source est composé de trois sous-packages principaux :

  - `models` : il contient deux sous-dossiers :
      - `beans` : contient les classes définissant les entités gérées par la plateforme avec des annotations pour Hibernate
      - `daos` : contient les classes définissant les opérations SQL sur les entités précédemment citées (ajout, modification, suppression, listing général ou particulier)

  - `webapp/WEB-INF` : il contient deux sous-dossiers :
      - `jsp ` : contient les fichiers footer, footerFrame, header, headerFrame, et configuration taglibs
      - `views` : contient l'ensemble des autres fichiers jsp

  - `controllers` : il contient les classes controllers de chaque entité gérée par la plateforme

Ainsi que de 2 classes de configuration:

  - `Config` et `EmailSingleton` : configure la fonction email de la plateforme.
      - Fichier de configuration : doit être au chemin ~/escalade.properties
```
email_host=<smtp serveur>
email_port=<smtp port>
email_mode=<0 non crypté, 1 SSL, 2 TLS>
email_user=<user>
email_pass=<password>
```

Et un filtre de servlet:
  - `GuestFilter` : initialise les sessions vierges en tant qu'utilisateur invité (donc sans rôle particulier)

### Pré-requis

  * Assurez-vous que [Java 12](https://www.oracle.com/fr/java/technologies/javase-downloads.html), [Maven 3](http://maven.apache.org/) et [Tomcat 9](https://tomcat.apache.org/download-90.cgi) sont installés:

```bash
java -version
mvn -version
```

 * Compilation

```bash
mvn package
```

### Base de données

*Les amis de l'escalade* nécessite l'utilisation d'une base de données relationnelle. [MySQL 5](https://www.mysql.com/), [MariaDB 10](https://mariadb.org/) et [H2](https://www.h2database.com/) ont été testés.

La configuration souhaitée dont être renseignée dans le fichier `src/main/resources/hibernateConf.xml`

Pour MySQL:

```xml
<property name="hibernateProperties">
    <props>
        <prop key="hibernate.hbm2ddl.auto">
            update
        </prop>
        <prop key="hibernate.dialect">
            org.hibernate.dialect.MySQL5Dialect
        </prop>
    </props>
</property>

...

<bean id="dataSource"
      class="org.apache.tomcat.dbcp.dbcp2.BasicDataSource">
    <property name="driverClassName" value="com.mysql.cj.jdbc.Driver" />
    <property name="url" value="jdbc:mysql://<host>:<port>/<db>?serverTimezone=UTC&amp;useSSL=false" />
    <property name="username" value="<username>" />
    <property name="password" value="<password>" />
</bean>
```

Pour H2:

```xml
<property name="hibernateProperties">
    <props>
        <prop key="hibernate.hbm2ddl.auto">
            update
        </prop>
        <prop key="hibernate.dialect">
            org.hibernate.dialect.H2Dialect
        </prop>
    </props>
</property>

...

<bean id="dataSource"
      class="org.apache.tomcat.dbcp.dbcp2.BasicDataSource">
    <property name="driverClassName" value="org.h2.Driver" />
    <property name="url" value="jdbc:h2:~/escalade" />
    <property name="username" value="sa" />
    <property name="password" value="sa" />
</bean>
```

### Utilisation

Copier le ficher `target/escalade-1.0.0.war` généré dans le dossier `webapps` de Tomcat.

Démarrer en faisant un `bin/catalina.sh run` ou un *service tomcat start* si le Tomcat est installé en tant que service.

Après inscription, le premier utilisateur devra renseigner la valeur 3 dans la colonne `<DB>.USER.role`, en base de données, pour devenir administrateur de la plateforme.

## Développé avec

IntelliJ IDEA CE

## Auteur

Olivier Morlotti
