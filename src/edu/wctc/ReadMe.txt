

THINGS TO NOTE:

The driver class for this program is the Main class, run the program from there. 
This program was designed to implement GRASP, Encapsulation, and SOLID principles. 
This program implements the Strategy, Singleton, and Factory design patterns as required by the assignment. 
It also implements the Command design pattern as optionally required by the assignment to have an additional design
pattern implemented.
Clarification on implimented design patterns can be found in the 'Room' (Strategy), 'Maze' (Singleton),
'RoomCreator' (Factory Method), and 'MazeController' (Command) code files, respectively.
There is a JUnit test file that thoroughly tests this program.
Please see the roadmap below for the locations of the files mentioned above.



ROADMAP:

src.edu.wctc:
    - Main = driver class, run the program from here
    - Maze = Singleton implementation (see Javadoc comment in this file for more details)
    - MazeController = part of the Command pattern implementation (see Javadoc comment in this file for more details)
    - .commands: 
        * Files for the Command pattern implementation
        * See the Javadoc comment found in the file ‘MazeController’ (in root src.edu.wctc package) for more
          information regarding the Command pattern implementation
    -.roomFactoryMethod:
        * Files for the Factory Method pattern implementation
        * See the Javadoc comment found in the file ‘RoomCreator (in this package) for more information regarding the
          Factory Method pattern implementation
    -.rooms:
        * Files for the Strategy pattern implementation
        * See the Javadoc comment found in the file ‘Room’ (in this package) for more information regarding the
          Strategy pattern implementation
    -.test:
        * Contains a JUnit test file



IMPLEMENTATION OVERVIEW:

GRASP:
The responsibility for each action is assigned to the class that has the most information required to fulfill that
responsibility. For example, the Player class handles player-related actions like inventory management and scoring.
Classes are designed with a single, well-defined purpose, ensuring that each class has high cohesion. For instance,
the Maze class is responsible for maze navigation and state management.
The classes are loosely coupled, facilitating flexibility and maintainability. Each class interacts with other classes
through well-defined interfaces which reduces dependencies.

Encapsulation:
The fields and methods of each class are appropriately encapsulated. For example, the Player class encapsulates
player-specific data and methods related to inventory management. Complex functionalities are abstracted away behind
simpler interfaces, allowing clients to interact with objects at a higher level of abstraction. For instance, the
MazeController provides a simplified interface for interacting with the maze.

SOLID:
Single Responsibility Principle (SRP): Each class has a single responsibility and reason to change. For example, the
Maze class is responsible for maze logic, while the Player class handles player-related functionalities.
Open/Closed Principle (OCP): The code is open for extension but closed for modification. New functionalities can be
added by creating new classes that adhere to existing interfaces without modifying existing code.
Liskov Substitution Principle (LSP): Subtypes can be substituted for their base types without affecting the
correctness of the program. For instance, different types of rooms can be used interchangeably in the maze without
impacting maze navigation.
Interface Segregation Principle (ISP): Interfaces are segregated to ensure that clients only depend on the methods
they use. For example, the Command and ReturningCommand interfaces provide different levels of abstraction based on the
expected behavior.
Dependency Inversion Principle (DIP): High-level modules (e.g. the MazeController) depend on abstractions (like the
interfaces) rather than concrete implementations, which makes for more flexible code.


JAVADOC COMMENTS REGARDING PATTERN IMPLEMENTATION:

From 'Room' (Strategy):
Location: src.edu.wctc.rooms
/**
 * The Room class, and its related interfaces/classes, were made to follow the Strategy Design Pattern.
 * The common attributes and actions to all rooms as they would relate to this program are all wrapped up in this
 * abstract class.
 * Unique and/or repeated actions for more specific room types that won't necessarily be available to some room types
 * were separated out into Interfaces to allow for concrete instances of Room objects to be more modular.
 * For instance, the InteractAndLoot and AllActionable are used to encapsulate different strategies for defining room
 * behaviors, as implemented in the EastRoom and ExitRoom classes.
 *
 * */

From 'Maze' (Singleton):
Location: src.edu.wctc
/**
 * This class builds and operates the Maze that users must navigate through in the game.
 * It was made to implement the Singleton Design Pattern.
 * The Maze object is instantiated at declaration as a private static final object.
 * This makes the Maze self-contained inside the class itself without the ability to create another instance.
 * Doing this will protect the data contained inside the Maze object and ensures that when only one of an object should
 * exist at a time, that there is only one.
 *
 * */

From 'RoomCreator' (Factory Method):
Location: src.edu.wctc.roomFactoryMethod
/**
 * This class was created in order to implement the Factory Method Design Pattern.
 * The sole purpose of this class and its subclasses is to create and return new concrete Room objects when called.
 * This allows for flexible creation of Room objects whenever that might be needed.
 *
 * */

From 'MazeController' (Command):
Location: src.edu.wctc.commands
/**
 * This class was created as a means to control the user's journey through the maze by utilizing the
 * Command Strategy Pattern.
 * Actions in the maze game are taken by utilizing the methods found in this class.
 * The methods in this class take advantage of several commands that were created to accompany the various actions you
 * can take in the game, as well as a few other pieces that impact the user interface directly.
 * Because the actions being taken and the interface involved are relatively unique, it was not programmed as a
 * universal controller, but rather one that could operate a Maze object for this game specifically.
 * This gives the flexibility to make additional Mazes utilizing the same set of controls in the future.
 * It also provides the option to modify actions later if there ends up being some change to the interface.
 * These actions could also be ported to a universal controller style if needed.
 *
 * */
