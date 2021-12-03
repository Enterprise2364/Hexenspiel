# Witch Dash

*Group members: Antoine Blot, Brice Le Rousseau, Edward Haynes, Johannes Steinhausen, Joanna Senn, Nicolas Martin*

### A project for: Programming II / Software Engineering (Franklin - Autumn 2021)


---

# Table of contents

1. [Introduction](#introduction)
2. [Aims](#aims)
3. [Context](#context)
4. [Installation instructions](#installation-instructions)
5. [Player controls](#player-controls)
6. [User Stories](#user-stories)
7. [Releaseplan](#releaseplan)
8. [Documentation Sprint 1](#documentation-sprint-1)
9. [Documentation Sprint 2](#documentation-sprint-2)
10. [Conclusion](#conclusion)


---
# Introduction
This Git Repository corresponds to a groupwork project for the course Software Engineering and Programming II (Java). We were tasked with conceiving, developing and programming a programme in java.

Starting on the project just before Halloween, we decided to produce a game, which we called *Witch Dash*. The aim of the game is to avoid pumpkins which fly towards the witch character, controlled by the player using the keyboard. If the witch collides with three pumpkins, the game is over. We implementated the game using java and java FX.

---

# Aims
The aim of the project was to apply what we have learned in our software engineering and programming II classes, using Java, Java FX, Git, and Jira. We wanted the end product to be a simple game, which would be fun to play.

---

# Context

The project should be programmed in Java respectively in JavaFx. Playing the game should be easy and fun, and it should have an attractive design. All team members should work equally on the project. The programm should have a JUnit-test for testing the Programm and a Maven package for player without maven installed.

---

# Installation instructions
  1. Download all files from this github repository.
  2. Unzip and save the files to a folder of your choice.
  3. Copy the path of the desired version file (.jar) to the clipboard.
  4. Open your computer's console or terminal
  5. There, enter java -jar followed by the copied path (.jar).

---

# Player controls

Once the game has started, you can move your witch character up and down using the W and S keys on your keyboard. Pumpkins will come from the right, move to stay out of their way. If you loose all of your lives, you'll have to start again.

---

# User Stories

| US | Description | Acceptance criteria | Priority | Story Points |
|----|----|----|----|----|
| 1 | As a user I control the movements of the witch character with the keyboard. | The program should recognise keyboard inputs and move the character accordingly. | high | 15 |
| 2 | As a user, I expect that the obstacles fly towards the witch character at alternating heights. | With the help of a random function, the objects appear at different heights. | high | 10 |
| 3 | As a user, I want there to be a main menu in which to choose settings and start the game. | A main menu with start and exit button shall be available to the player. | medium | 10 |
| 4 | As a user, I would like to be informed immediately if I have lost the game. | If the player hit the obstacle, a new window shall open. | high | 15 |
| 5 | As a user, I would like to be able to set the different difficulty levels for the game in the main menu, to keep it interesting. | The level of difficulty can be selected in the main menu before beginning a game. More objects appear at higher levels. | medium | 10 |
| 6 | As a user playing the game, I would like to have multiple lives for my character, so that the game is not over too soon.  | Each collision with the obstacle subtract the player one lives. | high | 10 |
| 7 | As a user, I want to know, if I won the game | If the player wins the game, a new window shall open | medium | 10 |
| 8 | As a user, i want to be able to destroy pumpkin objects with a projectile. | If the Player press a key, the Witch shoot a projectile whereby the obstacle can be destroyed. | medium | 10 |
| 9 | As a programmer, I would like the game to be managed by a game engine. | A game engine managed the Main class. This avoid "Spaghetti code" in the project.| high | 15 |
| 10 | As a programmer, I want to be able to easily understand the programme so that I can rebuild it, maintain it and add new features. | Comments, logical structure. | high | 5 |

---

# Releaseplan

| US | Release 1 | Release 2 | Release 3 |
|----|----|----|----|
|1| Release 1 | | |
|2| Release 1 | | |
|3| | Release 2 | |
|4| Release 1 | | |
|5| | Release 2 | |
|6| | Release 2 | |
|7| | | Release 3 |
|8| | | Release 3 |
|9| | Release 2 | |
|10| | | Release 3 |

---

# Documentation Sprint 1

| Userstory | Description | Estimated effort |
|----|----|----|
| 1 | Control of the witch with the keyboard | 300 min |
| 2 | Movement of the pumpkin | 210 min |
| 4 | Making a Collision test & Pop-up Window | 300 min |

### Tasklist

| Userstory | Task | Description | 
|----|----|----|
| 0 | I | Creating a Stage for all objects |
| 1 | I | Creating a class Witch |
| 1 | II | Creating four method MoveUp, MoveDown, MoveRight & MoveLeft |
| 1 | III | Creating a Loop for the Movements |
| 2 | I | Creating a class Pumpkin |
| 2 | II | Creating four method MoveUp, MoveDown, MoveRight & MoveLeft |
| 2 | III | Add the Pumkin to the Loop |
| 3 | I | Creating a class CollisionTest |
| 3 | II | Compare the Position of the witch and the pumpkin |
| 3 | III | Creating a Game Over Pop-up window |


## Documentation important Code Snippets

### 1.) Timeloop 

![image](https://user-images.githubusercontent.com/93000090/144055937-915a426b-9ce9-4800-a451-1ed17dbe2360.png)
![image](https://user-images.githubusercontent.com/93000090/144056004-106af7db-e1e4-4133-9641-0b52be266ed8.png)



With this part of our code, it seems possible to move two objects at the same time. The programme runs through the timeline at an interval of a certain time, in our case 10 milliseconds. With the Timeline.indefinite command, the loop continues indefinitely until it is manually interrupted.


### 2.) Collision Test

![image](https://user-images.githubusercontent.com/93000090/144563976-1381c0d6-a57f-4b8e-87a3-2e26ee322589.png)




To detect a collision between the Witch and the Pumpkin, this code snippet compares the positions of both objects. If a collision occurs, the loop is terminated and a Game Over window appears.

---

# Documentation Sprint 2

| Userstory | Tasks | Estimated effort |
|----|----|----|
| 3 | Creating a Main Menu | 210 min |
| 5 | Different difficulty Levels | 210 min |
| 6 | Multiple Lives for the Character | 210 min |
| 9 | Creating a game Engine | 300 min |

## Documentation important Code Snippets

### 1.) Multiple life

![image](https://user-images.githubusercontent.com/93608342/144523536-998bd1f4-c500-42a9-8f12-930a0ebf7302.png)
![image](https://user-images.githubusercontent.com/93000090/144405411-3234a1e8-f045-4bd9-ab4b-ed73a7e66f1d.png)


After the basic framework of the programme is in place, the witch character should have several lives at his or her disposal. If the witch gets hit, the variable inthit_point gets +1. If it has reached the witch's life points, the game is over.  


## Class diagramm

![image](https://user-images.githubusercontent.com/93000090/144564069-e98a0c71-6cda-4676-b0d3-147bcca8d430.png)



---

# Conclusion

A functioning Witch Dash game was realised which allows the user to play the game, with multiple pumpkin obstacles approaching the witch character, which itself can be moved to avoid the obstacles. The core element for this is the timeline. In sprint 2, a game engine was added along with difficulty levels, a main menu and game over screen. The group focused on achieving a functional game, meaning that further amending the code to permit a better overview, was left for a future sprint.
