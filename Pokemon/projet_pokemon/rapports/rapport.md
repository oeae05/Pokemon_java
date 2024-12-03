# Rapport de Projet

## Choix de Conception Actuels
- [X] Package Pokemon:
    - Classe `Pokemon`: classe qui permettant d'instancier les différents pokémons
    - Classe `GenerateurPokemon`: classe statique qui permet de générer un Pokemon à partir d'une liste de noms -> cela 
  permet de définir un nouveau pokemon sans instancier la classe.


- [X] Package Structure, 4 classes différentes :
  - Classe ``Défausse``: représente la défausse d'un joueur
  - Classe ``MainJoueur``: représente la main d'un joueur
  - Classe ``Pioche``: représente le deck d'un joueur
  - Classe ``Terrain``: représente le terrain d'un joueur


- [X] Package Joueurs, 3 classes différentes :
  - Classe mère et abstraite ``Joueur``: définit certaines méthodes et attributs pour n'importe quel type de joueur 
  (IA ou humain).
  - Classe ``Ordinateur`` : représente l'IA qui joue contre l'humain. cest surtout la méthode ``attaque`` qui diffère 
  du joueur humain.
  - Classe ``Humain``: représente le joueur humain qui joue contre l'IA.


- [X] Package Affinite, une interface et 4 classes qui implémentent celle-ci :
  - Interface ``TypePokemon``: définit les différentes méthodes nécessaires à la gestion des différents types de pokémon.
  - Classe ``TypeEau`` : vérifie si le pokemon possède un avantage / désavantage sur son adversaire en fonction de son type 
  - Classe ``TypeAir`` : vérifie si le pokemon possède un avantage / désavantage sur son adversaire en fonction de son type 
  - Classe ``TypeTerre`` : vérifie si le pokemon possède un avantage / désavantage sur son adversaire en fonction de son type 
  - Classe ``TypeFeu`` : vérifie si le pokemon possède un avantage / désavantage sur son adversaire en fonction de son type 

- [X] Package ErrorManager, 2 classes différentes :
  - Classe ``PokemonHasAlreadyAttacked``: gère l'exception en cas de tentative de la part de l'utilisateur d'utiliser 2 
  fois le même Pokemon en un tour.
  - Classe ``PokemonNotFound``: gère l'exception si le nom donné par l'utilisateur ne correspond à aucun Pokémon dans le
  contexte actuel.


- [X] Package Jeu, 2 classes différentes :
  - Classe ``Partie``: représente une nouvelle partie du jeu.
  - Classe ``Ronde``: représente deux tours de jeu (celui de l'utilisateur et celui de l'ordinateur) dans une ``Partie``.

  
- [X] Package Affichage:
    - Classe static `AffichagePokemon`: Affichage du nom du jeu
    - Classe static `AffichageRonde`: Affiche "rounde" pour annoncer un nouveau tour
    - Classe static `AffichageMonTerrain`: affiche " mon terrain " pour delimiter notre terrain
    - Classe static `AffichageTerrainIA`: affiche " terrainAI" pour delimiter le terrain de l'adversaire
    - Classe static `AfficherPokemon`: Afficher les pokemons avec leurs caractéristiques
    - Classe static `clear`: enleve l'affichage précedent
    - Classe static `afficherMain`: Affiche les pokemons present dans la main du joueur avec leurs caractéristiques

- [X] Package Pouvoir:
    - Interface `Pouvoir`: 
    - Classe `Ether`: à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). Le Pokémon change son affinité pour une affinité avec l'Ether. L'Ether est un élément ayant un 
                      avantage sur tous les autres.
    - Classe `FerveurGuerriere`: à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). Jusqu'à la fin de la partie ou à la mort du Pokémon choisi, les attaques de celui-ci   
                                  infligent 10 dégâts de plus.
    - Classe `Kamikaze`: à utilisation unique : le Pokémon choisit un Pokémon du camp adverse. Les deux Pokémons sont alors éliminés. 
    - Classe `nul`:
    - Classe `Peur`: à utilisation unique : le Pokémon choisit un Pokémon du camp adverse. Jusqu'à la fin de la partie ou à la mort du Pokémon choisi, les attaques de celui-ci infligent 10 dégats de moins.
    - Classe `Plombs`: à utilisation unique : le Pokémon choisit un Pokémon adverse. Le Pokémon change son affinité pour une affinité avec le plomb. Le Plomb est un nouvel élément sur lequel tous les autres 
                        éléments ont un avantage.
    - Classe `Regeneration`:  à utilisation unique : le Pokémon choisit un Pokémon de son camp. Si le Pokémon a déjà utilisé un pouvoir à utilisation unique, il peut alors l'utiliser une seconde fois.
    - Classe `SoinsTotal`: à utilisation unique : le Pokémon choisit un Pokémon de son camp (éventuellement lui-même). Celui-ci regagne toute sa vie.
    - Classe `Usurpation`: à utilisation unique : le Pokémon choisit un Pokémon (dans son camp ou dans le camp adverse). Il gagne alors le pouvoir du Pokémon choisi et le Pokémon choisi perd son pouvoir 
                          (fonctionne aussi pour les pouvoirs à utilisation unique déjà utilisés).


## Choix d'implémentation
- ``Pokemon`` et ``GenerateurPokemon``: Nous avons choisi de séparer les pokemon et la génération de ces derniers en 
deux classes différentes par souci de respect de la responsabilité des classes. Il était également plus simple de tester 
les différentes fonctionnalités avec une classe statique qui ne gère que la génération aléatoire de Pokémons.
- Package ``Structure``: la séparation des différentes "piles" de cartes Pokémons en 4 classes nous paraissait logique,
car bien qu'elles avaient des points communs entre elles, il y avait beaucoup de différences ce qui justifie
l'implémentation en plusieurs classes.
- Gestion des joueurs : la mise en place d'une classe abstraite ``Joueur`` est justifiée, car elle regroupe des méthodes 
communes au joueur humain et à l'IA. En effet, tous deux sont des joueurs qui piochent, attaquent ect. L'héritage en deux
classes ``Ordinateur`` et ``Humain`` était dans la suite logique de notre réflexion, parce que l'attaque d'un ordinateur n'est
pas la même que celle de l'humain.
- Gestion du jeu: nous avons décidé de séparer le déroulement d'un jeu en deux parties : la partie en soi qui gère les
différents tours, et une "round", qui gère seulement le déroulement du jeu pour un seul tour. Grâce à cette implémentation
, il nous était aisé de contrôler le déroulement du jeu et de ses règles.
- Gestion des exceptions : Afin de personnaliser un peu plus notre jeu, nous avons décidé de créer notre propre gestionnaire
d'exceptions, afin de contrôler les fautes de l'utilisateur. Il y a ainsi pour l'instant 2 classes d'exceptions, ``PokemonNotFound``
 et ``PokemoHasAlreadyattacked``, qui servent à expliquer les erreurs de l'utilisateur.
 - Gestion des types : Nous avons choisi de faire une interface générale ``typePokemon`` avec une classe par type qui implémente cette interface. Nous avons choisi une interface car, dans un premier temps, on ne peut pas faire d'instance d'une interface, ce qui fait que les Pokémon ne peuvent pas avoir un type autre que ceux des classes déjà implémentées. De plus, étant donné que les méthodes sont réimplémentées dans chaque classe, on peut donner plus ou moins d'avantages à un type sans modifier les avantages des autres types.
- Gestion de l'affichage : Pour l'affichage, nous avons choisi d'avoir une classe ``Affichage`` qui possède uniquement des méthodes statiques, ce qui permet de ne pas avoir besoin de créer une instance d'Affichage pour s'en servir.
- Gestion des pouvoirs : Pour implémenter els pouvoirs des Pokemons, nous avons opté pour une interface ``Pouvoirs`` qui nous permet
de définir les méthodes que doivent implémenter tous les pouvoirs. Etant donné que les pouvoirs sont assez différents au vu qu Pokemon 
sur lequel ils s'appliquent (Pokemon ennemi/allié), nous avons chosi en plus de cela de créér une classe ``GrandTerrain`` qui 
a pour fonction de rassembler les deux terrains des joueurs. Cela est à la fois logique, car les deux terrains sont censés 
être visibles par les deux joueurs, et cela nous permet de personnaliser la cible de chaque pouvoir.
- Gestion des entrées et sorties de l'écran: Pour contrôler les flux d'entrées et de sorties, nous avons jugé nécessaire de 
crééer deux classes ``Input`` et ``Output``.



## Difficultés Rencontrées
Nous n'avons pas rencontré de difficultés particulières mise à part peut-être pour l'implémentation des différents types de joueurs lors de laquelle le rajout d'une classe abstraite n'était pas évident.
Nous avons rencontré des problèmes lors de l'implémentation des méthodes permettant à un Pokémon d'utiliser son pouvoir. Il était nécessaire que ces méthodes soient permissives afin de pouvoir s'adapter aux besoins spécifiques du pouvoir (par exemple, le type de terrain sur lequel jouer, etc.) et qu'elles puissent être utilisées par l'ordinateur.
L'implémentation des pouvoirs nous a également posée quelques problèmes, car il a fallu gérer les diféerntes utilisation de par le joueur
humain et l'IA.

## Planification pour le Rendu Suivant
Pour le redu suivant, nous souhaiterions implémenter les fonctionnalités suivantes:
- [X] Gestion des tours
- [X] Gestion de l'interface utilisateur
- [X] Gestion des règles du jeu
- [X] Affichage
- [X] Optimisation du jeu et de l'affichage
- [X] Affichage de la fin du jeu
- [X] Affichage description des pouvoirs
- [X] implémentation de tous les pouvoirs
- [X] Utilisation des pouvoirs par l'IA et lez joueur humain
- [X] Test du bon fonctionnement de tous les pouvoirs
- [ ] Pouvoir unique sur le terrain
- [X] Implementations des tests