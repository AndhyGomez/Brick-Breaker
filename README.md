# Brick-Breaker 
 
My term project submission for my undergraduate Intro Java class. 
 
This game is a clone of traditional Block Breaking games such as breakout ball. Written in Java SE-12. 

![JFrameSS](https://user-images.githubusercontent.com/47075449/70033136-d44a7980-157c-11ea-94ef-9589d5666cfe.png)
                      
## Controls: 
Left arrow key: moves platform to the left 

Right arrow key: moves platform to the right 

Enter key: Start a new game once initial game has ended 
 

## Steps to Compile: 
#### **REQUIRES JAVA TO ALREADY BE INSTALLED ON YOUR MACHINE**
1. Download project as zip 
2. A) Windows 
     * Extract Brick-Breaker-Master folder
     * Copy path to within src folder
     
   B) MacOs
     * Copy path to within src folder 
3. A) Windows
     * Open Command Prompt
     * cd ctrl + v (Redirects you to src folder.)
     * javac Main.java
     * java Main
     
   B) MacOs
     * Open Terminal
     * cd cmd + v (Redirects you to src folder.)
     * javac Main.java
     * java Main
 
## Files: 
* Main.java 
  * Entry point for the program 
  
* GameLogic.java 
  * Contains logic/algorithms for the game 
  
* BrickMap.java 
  * Instantiates the map of bricks 
  
* History.java 
  * Contains method which writes scores to history text file 

## Note: 
If you’d like to adjust the map, intersections will continue to work as long as you adjust variable numBricks on line 25 of GameLogic.java in order to ensure the “Winner!” and “Game Over!” screens remain accurate. 
