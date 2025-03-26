# APIBurger_java
## Contexte
API CRUD (Create, Read, Update, Delete) permettant de gérer une entité Burger. Chaque burger contient les informations suivantes :

    id (UUID ou entier, clé primaire)
    nom (string) – Nom du burger
    description (string) – Courte description du burger
    prix (float) – Prix du burger
    disponible (boolean) – Indique si le burger est disponible ou non

## L’API expose les endpoints suivants :

    Créer un burger (POST /burgers)
    Récupérer la liste des burgers (GET /burgers)
    Récupérer un burger par son ID (GET /burgers/{id})
    Mettre à jour un burger (PUT /burgers/{id})
    Supprimer un burger (DELETE /burgers/{id})

    
## Environnement technique :
    Version java : openjdk 21.0.6 2025-01-21 LTS
    Environnement Spring Boot
    Base de données gérée par mySQL

## Utilisation :
    Créer une base de données, par exemple avec MySQL Workbench, nommée burger.
    Mettre à jour les username et password dans le fichier src/main/java/com/paulb/apiBurger/ressources/application.properties
    Lancer src/main/java/com/paulb/apiBurger/ApiBurgerApplication.java
    L'URL est http://localhost:8080/burgers
    Vous pouvez par exemple utiliser Postman (https://www.postman.com/) pour créer/lire/modifier/supprimer des burgers. 
    



