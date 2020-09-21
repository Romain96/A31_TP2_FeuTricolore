# A31 - TP2 - Feu tricolore

Auteur : Romain PERRIN - Ingénieur de recherche - Cancéropôle Est/ICube équipe SDS <romain.perrin@etu.unistra.fr>
Module : DUT S3 - A31 - Programmation et Conception Objet Avancées - IUT Robert SCHUMAN - 2020/21

# Description

Ce projet se compose de deux codes indépendants sobrement appelés *trafficLightV1* et *trafficLightV2*.
Le code a été développé sous Eclipse.

## Première version (trafficLightV1)

### Modèle

Il y a un objet de type **TrafficLight** implémentant un feu tricolore à 3 temps (vert -> orange -> rouge --> vert...).\
Cet objet contient deux méthodes principales *advanceCycle* et *turnOnOff* modifiant respectivement les deux attributs
*color* et *isRunning*.

### Vues

Il y a une interface principale de type **TrafficLightMainView** (JFrame) contenant deux fenêtres internes chacune étant un
type particulier. La fenêtre interne de type graphique est de type **TrafficLightGraphicalView** (JInternalFrame) et contient
deux boutons et un label. La fenêtre de type texte est de type **TrafficLightTextView** (JInternalFrame) et contient les
deux mêmes boutons et un label.

Le premier bouton permet d'appeler la méthode **TrafficLight.turnOnOff()** et le second bouton permet d'appeler
la méthode **TrafficLight.advanceCycle()**.

### Controleur

Il y a un gestionnaire d'événement pour traiter le premier bouton qui est de type **TrafficLightTurnOnOffEventHandler** et qui
appelle la méthode **TrafficLight.turnOnOff()** puis **TrafficLightMainView.update(...)**.\
Il y a un gestionnaire d'événement pour traiter le second bouton qui est de type **TrafficLightAdvanceCycleEventHandler** et qui
appelle la méthode **TrafficLight.advanceCycle()** puis **TrafficLightMainView.update(...)**.

## Seconde version (trafficLightV2)

### Modèle

La seconde version utilise le patron **stratégie** afin de permettre plusieurs représentations de feu tricolore.
L'idée est d'utiliser une interface **TrafficLightColorCycle** qui contient les méthodes **advanceCycle** et **turnOnOff**.
On définit ensuite deux implémémentations concrètes de feu tricolore implémentant cette interface.
Un feu de type français à 3 temps (vert -> orange -> rouge --> vert...) **TrafficLightFrenchModel** et un feu
de type allemand à 4 temps (vert -> orange -> rouge -> orange --> vert...) **TrafficLightGermanModel**.\
On définit un contexte **TrafficLightCycleContext** qui permettra de choisir le type de feu rendant le 
processus totalement opaque pour la classe **TrafficLight**.

### Vues

Idem que pour le v1

### Controleur

Idem pour les boutons et les événements associés.\
On ajoute ici la possibilité d'ajouter et de supprimer dynamiquement des fenêtre de type graphique et/ou texte.\
Il nous faut donc ajouter 4 gestionnaires d'événements : 2 pour ajouter les fenêtres (une de chaque type) et 2 pour les supprimer.\
Pour ajouter les fenêtres on utilise les classes **TrafficLightAddGraphicalEventHandler** et **TrafficLightAddTextEventHandler**.\
Pour supprimer les fenêtres on utilise les classes **TrafficLightRemoveGraphicalEventHandler** et **TrafficLightRemoveTextEventHandler**.\
Il y a aussi la possibilité de changer dynamiquement le type de feu; tout cela étant ajouter dans un menu (JMenuBar, JMenu, JMenuItem...).

