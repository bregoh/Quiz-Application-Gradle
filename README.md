# Quiz-Application-Gradle
This a Java Application built with Gradle Script

RUNNING THE APPLICATION
The command below can be used to run the application
C:/QuizApp > gradle build
C:/QuizApp > gradle run

WRITING A QUESTION-TYPE PLUGIN (GUI)
The design of the question type plugin depends on the developer. I will be explaining the steps to consider while writing the plugin

1. The class should extend the ShortAnswer or Multichoice class. Extending either class depends on the GUI the developer is designing.

2. The important methods to consider are :

a. reset method: This is a static void method from the Question class. It can be called when you want to restart the current quiz or reload a new quiz

b. printResult method: This method prints the final result to the UI. It is called at the end of the quiz or can be called when the user ends the quiz mid-way through the quiz test. It allows on String parameter to be passed

c. checkAnswer method: A static void method from the Question class. This method validates the answer of a given question. It allows on String parameter to be passed
d. runTest method: A static void method from the Question class. The method is called when the user wants the next question to be printed unto the screen.

e. next method: A static method from the Question class. The method invokes the next question to be printed on the screen.

f. reload method: A static method from the Question class. The method return the application to the initial state and request a new classname (quiz) be provided.

g. restart method: A static method from the Question class. The method start the current quiz session from the beginning and resets all values of the previous quiz session.

3. The class variables to consider includes:

a. previewQuestion: This is a static variable from Question class. It contains String of the next question to be printed unto the UI or null if the next question is not available

b. questions: This is inherited from either extended class, it contains String of the question to be printed onto the screen.

c. option: Inherited only from the Multichoice class, it contains an array of answer options.

d. timerInSeconds: Inherited from either extended class. It has a default integer value of 0.