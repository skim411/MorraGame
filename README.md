# Morra Italian Finger Game

This project implements the classic **Morra Italian Finger Game** using **Java** with a focus on **Object-Oriented Programming** principles. The game utilizes **Strategy** and **Factory Design Patterns** to create a dynamic and customizable gameplay experience.

## Features
- **Game Strategies**: Includes strategies for random, average, and top player moves, offering varied gameplay.
- **Robust Input Validation**: Ensures that user inputs are correctly validated to prevent errors.
- **Player History Tracking**: Keeps track of player statistics for an enhanced and more personalized experience.

## Design Patterns Used
- **Strategy Pattern**: Used to define different strategies for the game moves.
- **Factory Pattern**: Used to create different strategies dynamically based on the game context.

## Technologies
- **Java**: The core programming language used to implement the game logic.

## How to Run

Follow these steps to run the game on your local machine:

1. **Clone the Repository**:
   ```
   git clone https://github.com/skim411/morra-italian-finger-game.git
   ```

2. **Navigate to the Project Directory**:
   ```
   cd morra-italian-finger-game
   ```

3. **Navigate to the Java Source Folder**:
   If you haven't already, navigate to the `src/main/java` directory where the Java files are located:
   ```
   cd src/main/java
   ```

4. **Compile the Java Files**:
   Make sure you have [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) installed. Compile all the Java files in the `nz/ac/auckland/se281` directory:
   ```
   javac nz/ac/auckland/se281/*.java
   ```

5. **Run the Game**:
   After compiling, run the game by using the following command:
   ```
   java -cp . nz.ac.auckland.se281.Main
   ```

   - **Explanation**:
     - `-cp .` tells Java to use the current directory as the classpath, ensuring it can find the compiled `.class` files in `src/main/java`.
     - `nz.ac.auckland.se281.Main` specifies the fully-qualified class name of the main class in your project.
