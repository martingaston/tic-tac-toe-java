# Tic Tac Toe

## What is this?

An 2-player implementation of Tic Tac Toe in Java, the classic 3x3 grid adventure which supposedly ends in a draw if you know what you're doing. Played on the command line, because command lines are cool. 

## How do I play it? 

Compiling from sources requires an installation of the JDK - my personal preference is [OpenJDK](https://openjdk.java.net/), with this code being built on JDK 12. 

### Mac

#### Install Java

1.  Download OpenJDK for Mac OSX from  [http://jdk.java.net/](http://jdk.java.net/)
2.  Unarchive the OpenJDK tar (`sudo tar xzf ~/PATH_TO_JDK_FILE.tar.gz`) and place (`mv`) the extracted folder (i.e.  `jdk-12.jdk`) into  `/Library/Java/JavaVirtualMachines/`  folder, which is the expected location of JDK installs.
3. A quick `java --version`

#### Compile and Run

1. From the project root, `cd` into `src/main/java` 
2. run `javac *.java`
3. run `java main`

## User Stories in this Sprint

- ✅ Simple instructions for the user should be provided within the application itself
- ✅ The game is played on a standard 3 X 3 board  
- ✅ Players are represented by "X" and "O" markers  
- ✅ Won or tied games should be identified and game should end

## Opportunities to build upon the code in a future sprint

* The app assumes the happy path - that is to say, it does not check for incorrect input. The app will crash with an `InputMismatchException` if a user enters a non-integer, for instance, and the game will discard a user's turn if they overlap on a cell that's already been played.
* The presentation could be refined, with lightly coloured numbers in the background of currently unplayed squares - so it's easier for players to know what number to press to select the square they want. 
* There could be better testing for the main game loop itself.
